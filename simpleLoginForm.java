package LoginForm;

import com.sun.jdi.connect.spi.Connection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;


public class simpleLoginForm implements ActionListener {

    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton buttonLogin;
    private static JButton buttonReset;
    private static JLabel success;
    private static JPanel panel;
    private static JFrame frame;


    public static void main(String[] args) {

        panel = new JPanel();
        frame = new JFrame();
        frame.setSize(310, 190);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        frame.setTitle("My Login form");

        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);


        userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        buttonLogin = new JButton("Login");
        buttonLogin.setBounds(10, 80, 80, 25);
        buttonLogin.addActionListener(new simpleLoginForm());
        panel.add(buttonLogin);

        buttonReset = new JButton("Reset");
        buttonReset.setBounds(100, 80, 80, 25);
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userText.setText("");
                passwordText.setText("");
            }
        });
        panel.add(buttonReset);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);


        frame.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/registrations?useSSL=false", "root", "root");

            String username = userText.getText();
            String password = passwordText.getText();

        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
//        String user = userText.getText();
//        String password = passwordText.getText();
//        System.out.println(user + ", " + password);

    }
}
