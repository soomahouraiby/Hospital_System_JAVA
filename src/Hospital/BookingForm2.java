package Hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by HP on 30/12/18.
 */
public class BookingForm2 extends JFrame implements ActionListener{
    private JButton displayDoctor;
    private JButton addDoctor;
    private JButton Back;
    private JTextArea displayArea;
    private Booking rovers;

    public BookingForm2() {
        setTitle("My frame");
        setBounds(100, 100, 400, 400);

        // Adding some sample data


        Doctor_Data Ali = new Doctor_Data("Ali","Saleh","Ahmed","Alglal","777342345","AliAlglal@gmail",
                "Sana","Male","001000233467",2000,10,30);
        Doctor_Data Amal = new Doctor_Data("Amal","Muneer","Ahmed","Alglal","777356745","AmalAlglal@gmail",
                "Sana","Female","001000275467",1990,5,2);

        rovers = new Booking(2018,12,30);
        rovers.addDoctor(Ali);
        rovers.addDoctor(Amal);

        getContentPane().setLayout(new BorderLayout());
        // add controls and actionListeners
        displayDoctor = new JButton("Display all Doctor");
        displayDoctor.addActionListener(this);
        addDoctor = new JButton("Add new Doctor");
        addDoctor.addActionListener(this);
        Back = new JButton("Back");
        Back.addActionListener(this);

        JPanel p = new JPanel();
        p.add(displayDoctor);
        p.add(addDoctor);
        p.add(Back);
        getContentPane().add("North", p);

        JPanel northPanel = new JPanel();
        displayArea = new JTextArea("This is the display area    " +
                "\nDetails of Doctor will be displayed here      " +
                "\nPlease make your choice\n\n\n\n\n\n");
        JScrollPane scrollPane;
        scrollPane = new JScrollPane(displayArea);
        northPanel.add(scrollPane);
        getContentPane().add("Center", northPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == displayDoctor) {
           // this.dispose();
            try {
                FileReader r = new FileReader("doctor.txt");

                int x;
                while ((x=r.read())!=-1) {
                    System.out.print((char)x);
                    rovers.details1(displayArea);
                }

            }
            catch (Exception ex){

            }
            //rovers.details1(displayArea);
        } else if (e.getSource() == addDoctor) {
           // this.dispose();
            try {
                Add_Doctor dlg =
                        new Add_Doctor("Add a new Doctor  Dialog", this);
                dlg.setVisible(true);
                Doctor_Data doctor = dlg.getDoctor();
                if (doctor != null) {
                    //displayArea.setText(doctor.getDoctorinf());
                    rovers.addDoctor(doctor);
                    FileWriter r = new FileWriter("doctor.txt");
                    r.write("Doctor" + doctor + "\n");
                    r.flush();
                    r.close();
                    displayArea.setText("Doctor added");

                } else
                    displayArea.setText("Doctor not added");
            }
            catch (Exception ex){

            }
        }
        else if (e.getSource() == Back)
           // this.dispose();
            new FirstForm().setVisible(true);
    }

}
