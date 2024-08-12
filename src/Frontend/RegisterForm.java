package Frontend;

import Backend.mainConstants;
import Database.JavaDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterForm extends Form {

    public RegisterForm() {
        super("Register");
        addGuiComponents();
    }

    private void addGuiComponents(){

        // Creating the register label
        JLabel registerLabel = new JLabel("Register");
        registerLabel.setBounds(0, 25, 520, 100);
        registerLabel.setForeground(mainConstants.TEXT_COLOR);
        registerLabel.setFont(new Font("Dialog", Font.BOLD, 40));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(registerLabel);

        // Username label
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(30, 150, 400, 25);
        usernameLabel.setForeground(mainConstants.TEXT_COLOR);
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(usernameLabel);

        // Username text field
        JTextField usernameField = new JTextField();
        usernameField.setBounds(30, 185, 450, 55);
        usernameField.setBackground(mainConstants.SECONDARY_COLOR);
        usernameField.setForeground(mainConstants.TEXT_COLOR);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(usernameField);

        // Password label
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 255, 400, 25);
        passwordLabel.setForeground(mainConstants.TEXT_COLOR);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(passwordLabel);

        // Username text field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(30, 285, 450, 55);
        passwordField.setBackground(mainConstants.SECONDARY_COLOR);
        passwordField.setForeground(mainConstants.TEXT_COLOR);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(passwordField);

        // Re-enter password label
        JLabel rePasswordLabel = new JLabel("Re-enter Password:");
        rePasswordLabel.setBounds(30, 365, 400, 25);
        rePasswordLabel.setForeground(mainConstants.TEXT_COLOR);
        rePasswordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(rePasswordLabel);

        // Username text field
        JPasswordField rePasswordField = new JPasswordField();
        rePasswordField.setBounds(30, 395, 450, 55);
        rePasswordField.setBackground(mainConstants.SECONDARY_COLOR);
        rePasswordField.setForeground(mainConstants.TEXT_COLOR);
        rePasswordField.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(rePasswordField);

        // Login button
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Dialog", Font.BOLD, 18));

        // Changing the cursor to a hand when hover over the button
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.setBackground(mainConstants.TEXT_COLOR);
        registerButton.setBounds(125, 520, 250, 50);
        registerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText(); // Getting username
                String password = new String(passwordField.getPassword()); // Getting password
                String rePassword = new String(rePasswordField.getPassword()); // Getting re-password

                // Validating user input
                if(validateUserInput(username, password, rePassword)) {
                    // Registering user to the database
                    if(JavaDBC.register(username, password)) {
                        // dispose of this gui
                        RegisterForm.this.dispose();

                        // Taking user back to the login gui
                        LoginForm loginFormGUI = new LoginForm();
                        loginFormGUI.setVisible(true);

                        // A result dialog will be created.
                        JOptionPane.showMessageDialog(loginFormGUI,
                                "Account registered successfully!");
                    } else {
                        // Register failed (Maybe the user already exists in the database)
                        JOptionPane.showMessageDialog(RegisterForm.this,
                                "Try again: Username already exists!");
                    }
                } else {
                    // Invalid user input
                    JOptionPane.showMessageDialog(RegisterForm.this,
                            "Try again: Username must be at least SIX characters \n" +
                                    "and/or passwords must match");
                }
            }
        });
        add(registerButton);

        // Register label (Used to load the register GUI)
        JLabel loginLabel = new JLabel("Have an account? Login here");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginLabel.setForeground(mainConstants.TEXT_COLOR);

        // When clicked it will launch the login form gui
        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // Disposing of this GUI
                RegisterForm.this.dispose();
                // Launching the register gui
                new LoginForm().setVisible(true);
            }
        });
        loginLabel.setBounds(125, 600, 250, 30);
        add(loginLabel);
    }

    private boolean validateUserInput(String username, String password, String rePassword){

        if(username.length() == 0 || password.length() == 0 || rePassword.length() == 0)
            return false;

        // Username has to be at least SIX characters long.
        if(username.length() < 6)
            return false;

        // Password and re-password must be the same
        if(!password.equals(rePassword))
            return false;

        // If it passes validation...
        return true;
    }
}











