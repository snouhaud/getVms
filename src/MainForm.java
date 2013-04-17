import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: snouhaud
 * Date: 11/02/13
 * Time: 18:14
 * To change this template use File | Settings | File Templates.
 */
public class MainForm {
    private JTextField nomField;
    private JPanel panel1;
    private JPasswordField passwordField;
    private JLabel nameLabel;
    private JLabel passwordLabel;

    public void setData(Login data) {
        nomField.setText(data.getNomField());
        passwordField.setText(data.getPasswordField());
    }

    public void getData(Login data) {
        data.setNomField(nomField.getText());
        data.setPasswordField(passwordField.getText());
    }

    public boolean isModified(Login data) {
        if (nomField.getText() != null ? !nomField.getText().equals(data.getNomField()) : data.getNomField() != null)
            return true;
        if (passwordField.getText() != null ? !passwordField.getText().equals(data.getPasswordField()) : data.getPasswordField() != null)
            return true;
        return false;
    }
}
