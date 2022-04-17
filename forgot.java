package semesterproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class forgot extends JFrame implements ActionListener {

    Connection con;
    JButton button;
    JTextField t1, t2;

    forgot() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        JLabel background;
        ImageIcon img = new ImageIcon("pl.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(10, 0, 1200, 1200);

        this.setResizable(false);

        t1 = new JTextField("");
        JLabel label1 = new JLabel("EMAIL");
        label1.setBounds(240, 150, 400, 40);
        label1.setFont(new Font("Times new roman", Font.BOLD, 30));
        label1.setBackground(Color.white);
        label1.setForeground(Color.black);
        t1.setBounds(200, 200, 200, 30);
        t2 = new JTextField("");
        t2.setBounds(200, 300, 200, 30);
        JLabel label2 = new JLabel("     CONFIRMATION CODE");
        label2.setBounds(100, 250, 400, 40);
        label2.setFont(new Font("Times new roman", Font.BOLD, 30));
        label2.setBackground(Color.white);
        label2.setForeground(Color.black);

        button = new JButton("NEXT");
        button.setBackground(Color.WHITE);
        button.setForeground(Color.blue);
        button.setBounds(250, 450, 100, 40);

        this.add(button);
        this.add(t1);
        this.add(t2);
        this.add(label1);
        this.add(label2);
        button.addActionListener(this);
        this.add(background);
        this.setVisible(true);
        createDatabase();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == button) {
            try {

                Statement st = con.createStatement();

                String sql = "select email, aucode from sign where email ='" + t1.getText() + "'and aucode = '" + t2.getText() + "'";
                ResultSet RS = st.executeQuery(sql);
                if (RS.next()) {
                    this.dispose();
                    pas p = new pas(t1.getText());
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong inputs!");
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }

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

//    public static void main(String[] args) {
//        forgot f = new forgot();
//    }
}
