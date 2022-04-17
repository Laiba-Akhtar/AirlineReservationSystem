package semesterproject;

import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;

public class AboutUs {
    JFrame f;
    JLabel icon;
    JLabel aboutus;
    JLabel welcome;
    JLabel name;
    JLabel l;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;

    AboutUs() {
        f = new JFrame("About Us");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setSize(900, 650);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.getContentPane().setBackground(new Color(200, 0, 50));

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

        aboutus = new JLabel("About Us");
        aboutus.setBounds(410, 220, 440, 80);
        aboutus.setForeground(Color.yellow);
        aboutus.setFont(new Font("Sans Serif", Font.BOLD, 80));

        l = new JLabel(" Airline reservation systems (ARS) are systems");
        // It
        // contains information on schedules
        // and fares and contains a database of reservations (or passenger name records)
        // and of tickets issued (if applicable).");
        l.setBounds(400, 300, 800, 50);
        l.setFont(new Font("Sans Sarif", Font.BOLD, 20));
        l.setForeground(Color.black);

        l1 = new JLabel(" that allow an airline to sell their inventory (seats).");
        // It
        // contains information on schedules
        // and fares and contains a database of reservations (or passenger name records)
        // and of tickets issued (if applicable).");
        l1.setBounds(400, 320, 800, 50);
        l1.setFont(new Font("Sans Sarif", Font.BOLD, 20));
        l1.setForeground(Color.black);

        l2 = new JLabel(" It contains information on schedules and fares");
        // and fares and contains a database of reservations (or passenger name records)
        // and of tickets issued (if applicable).");
        l2.setBounds(400, 340, 800, 50);
        l2.setFont(new Font("Sans Sarif", Font.BOLD, 20));
        l2.setForeground(Color.black);

        l3 = new JLabel("and contains a database of reservations or");
        // and fares and contains a database of reservations (or passenger name records)
        // and of tickets issued (if applicable).");
        l3.setBounds(400, 360, 800, 50);
        l3.setFont(new Font("Sans Sarif", Font.BOLD, 20));
        l3.setForeground(Color.black);

        l4 = new JLabel("and of tickets issued By Laiba Akhtar (20sw057),");
        // and fares and contains a database of reservations (or passenger name records)
        // and of tickets issued (if applicable).");
        l4.setBounds(400, 380, 800, 50);
        l4.setFont(new Font("Sans Sarif", Font.BOLD, 20));
        l4.setForeground(Color.black);

        l5 = new JLabel("Anousha(20sw030),Zohaib(20sw036),Rukhsar(20sw137)");
        // and fares and contains a database of reservations (or passenger name records)
        // and of tickets issued (if applicable).");
        l5.setBounds(360, 400, 800, 50);
        l5.setFont(new Font("Sans Sarif", Font.BOLD, 20));
        l5.setForeground(Color.black);

        f.add(l);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(icon);
        f.add(welcome);
        f.add(name);
        f.add(aboutus);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

   public static void main(String[] args) {
       AboutUs a = new AboutUs();
   }
}
