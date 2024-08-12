import Frontend.LoginForm;

import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Instantiate a LoginFormGUI obj and make it visible
                new LoginForm().setVisible(true);

                // Check user test
                // System.out.println(MyJDBC.checkUser("Astro"));

                // Check register test
                // System.out.println(MyJDBC.register("Astro", "Coder"));

                // Check validate login test
                // System.out.println(MyJDBC.validateLogin("Astro", "Coder"));
            }
        });
    }
}
