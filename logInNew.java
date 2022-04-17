/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterproject;

/**
 *
 * @author HP
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class logIn2 implements ActionListener {

    JFrame f;
    JLabel l;
    JTextField t1;
    JPasswordField t2;
    JLabel l1;
    JLabel l2;
    JLabel welcome;
    JLabel name;
    JLabel icon;
    JButton b1;
    JButton b2;
    JButton b3;
    ImageIcon image;

    Connection con;
    PreparedStatement stmt;
    ResultSet rs;

    logIn2() {
        
        // icon
        ImageIcon image = new ImageIcon("dude1.png");
        icon = new JLabel();
        icon.setBounds(80, 65, 252, 247);
        icon.setIcon(image);

        welcome = new JLabel(" INTERNATIONAL ");
        welcome.setBounds(40, 330, 400, 40);
        welcome.setForeground(Color.yellow);
        welcome.setFont(new Font("Sans Serif", Font.BOLD, 40));

        name = new JLabel(" AIRLINES ");
        name.setBounds(110, 400, 440, 40);
        name.setForeground(Color.yellow);
        name.setFont(new Font("Sans Serif", Font.BOLD, 40));

        // Frame
        // createDatabase();
        f = new JFrame("LOGIN PAGE");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setSize(900, 650);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(new Color(200, 0, 50));

        // TextField
        t1 = new JTextField();
        t1.setBounds(600, 150, 200, 35);
        f.add(t1);
        t2 = new JPasswordField();
        t2.setBounds(600, 260, 200, 35);
        f.add(t2);

        f.add(welcome);
        f.add(name);
        f.add(icon);

        // Label
        l1 = new JLabel("Email : ");
        l1.setBounds(460, 150, 180, 50);
        l1.setFont(new Font("Sans Serif", Font.BOLD, 20));
        l1.setForeground(Color.yellow);
        f.add(l1);
        l2 = new JLabel("Password : ");
        l2.setBounds(460, 260, 180, 50);
        l2.setFont(new Font("Sans Sarif", Font.BOLD, 20));
        l2.setForeground(Color.yellow);
        f.add(l2);

        // Buttons
        b1 = new JButton("Log In");
        b1.setBounds(460, 340, 350, 40);
        b1.setFont(new Font("Sans Sarif", Font.BOLD, 16));
        b1.setForeground(Color.yellow);
        b1.setBackground(new Color(200, 0, 50));
        b1.setBorder(BorderFactory.createLineBorder(Color.white, 3));
        f.add(b1);

        b2 = new JButton("Sign Up");
        b2.setBounds(680, 410, 100, 40);
        b2.setFont(new Font("Sans Sarif", Font.BOLD, 16));
        b2.setBorder(BorderFactory.createLineBorder(Color.white, 3));
        b2.setForeground(Color.yellow);
        b2.setBackground(new Color(200, 0, 50));
        f.add(b2);

        b3 = new JButton("Forgotten Pass ?");
        b3.setBounds(500, 410, 160, 40);
        b3.setFont(new Font("Sans Sarif", Font.BOLD, 16));
        b3.setBorder(BorderFactory.createLineBorder(Color.white, 3));
        b3.setForeground(Color.yellow);
        b3.setBackground(new Color(200, 0, 50));
        f.add(b3);
        b3.addActionListener(this);
        b2.addActionListener(this);
        b1.addActionListener(this);

        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        createDatabase();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {

                if (t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(f, "Enter your email?");
                } else if (t2.getText().equals("")) {
                    JOptionPane.showMessageDialog(f, "Enter your pass!");
                } else {
                    Statement st = con.createStatement();

                    String sql = "select * from sign where email ='" + t1.getText() + "'and pass = '" + t2.getText() + "'";
                    ResultSet RS = st.executeQuery(sql);
                    if (RS.next()) {
                        f.dispose();
                        HomeScreen2 homeScreen = new HomeScreen2();
                    } else{
                        JOptionPane.showMessageDialog(f, "Wrong inputs!");
                    }
                }

            } catch (HeadlessException | SQLException e) {
                System.out.println(e + " exxx");
            }
        } else if (ae.getSource() == b2) {
            f.dispose();
            signUp sign=new signUp();
            
        } else if (ae.getSource() == b3) {
            f.dispose();
            forgot forget =new forgot();
        }
    }

    private void createDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "");

            System.out.println("Database Connection Successfull");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e + " hello");
        }
    }

    public static void main(String[] args) {
        logIn2 logIn = new logIn2();
    }
}