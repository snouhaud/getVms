import com.vmware.vim25.VirtualMachineCapability;
import com.vmware.vim25.VirtualMachineConfigInfo;
import com.vmware.vim25.mo.*;

import java.net.URL;

public class Main {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        ServiceInstance si = new ServiceInstance(new URL("https://192.168.1.96/sdk"), "root", "vmware", true);
        long end = System.currentTimeMillis();
        System.out.println("time taken:" + (end-start));
        System.out.println(" ");
        Folder rootFolder = si.getRootFolder();
        String name = rootFolder.getName();
        System.out.println("root:" + name);
        ManagedEntity[] mes = new InventoryNavigator(rootFolder).searchManagedEntities("VirtualMachine");
        if(mes==null || mes.length ==0)
        {
            return;
        }

        for (ManagedEntity managedEntity : mes) {
            VirtualMachine vm = (VirtualMachine) managedEntity;

            VirtualMachineConfigInfo vminfo = vm.getConfig();
            VirtualMachineCapability vmc = vm.getCapability();

            vm.getResourcePool();
            System.out.println("Vm " + vm.getName() + " " + vm.getGuest().getGuestState());
            System.out.println("GuestOS: " + vminfo.getGuestFullName() + " " + vm.getGuest().getGuestFamily());
            System.out.println("Multiple snapshot supported: " + vmc.isMultipleSnapshotsSupported());
            System.out.println("Ip:" + vm.getGuest().getIpAddress());
            System.out.println("   ");
        }

        si.getServerConnection().logout();
    }
}
