package Hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by HP on 30/12/18.
 */
public class BookingForm extends JFrame implements ActionListener {
    private JButton displayPatient;
    private JButton addPatient;
    private JButton Back;
    private JButton search;

    private JTextArea displayArea;
    private Booking rovers;
    private Patient_Data p;

    public BookingForm() {
        setTitle("My frame");
        setBounds(100, 100, 400, 400);

        // Adding some sample data

        Patient_Data Ali = new Patient_Data("Ali","Saleh","Ahmed","Alglal","777342345","AliAlglal@gmail",
                "Sana","Male","001000233467",2000,10,30," sana111","Married");
        Patient_Data Amal = new Patient_Data("Amal","Muneer","Ahmed","Alglal","777356745","AmalAlglal@gmail",
                "Sana","Female","001000275467",1990,5,2," sana133","Student");

        rovers = new Booking(2018,12,30);
        rovers.addPatient(Ali);
        rovers.addPatient(Amal);

        //rovers.addDoctor(Ali);
        //rovers.addDoctor(Amal);
        //getContentPane().setLayout(new BorderLayout());
        // add controls and actionListeners
        displayPatient = new JButton("Display all patient");
        displayPatient.addActionListener(this);
        addPatient = new JButton("Add new patient");
        addPatient.addActionListener(this);
        Back = new JButton("Back");
        Back.addActionListener(this);
        search = new JButton("Search");
        search.addActionListener(this);

        JPanel p = new JPanel();
        p.add(displayPatient);
        p.add(addPatient);
        p.add(Back);
        p.add(search);

        getContentPane().add("North", p);

        JPanel northPanel = new JPanel();
        displayArea = new JTextArea("This is the display area    " +
                "\nDetails of patient will be displayed here      " +
                "\nPlease make your choice\n\n\n\n\n\n");
        JScrollPane scrollPane;
        scrollPane = new JScrollPane(displayArea);
        northPanel.add(scrollPane);
        getContentPane().add("Center", northPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == displayPatient) {

            //this.dispose();
           try {
                FileReader r = new FileReader("text.txt");

                int x;
                while ((x=r.read())!=-1) {
                   System.out.print((char)x);
                    rovers.details(displayArea);
                }

            }
            catch (Exception ex){

            }
            rovers.details(displayArea);

        } else if (e.getSource() == addPatient) {
           // this.dispose();
            try {

                    Add_Patient dlg =
                        new Add_Patient("Add a new Patient  Dialog", this);
                      dlg.setVisible(true);
                     Patient_Data patient = dlg.getPatient();
                     if (patient != null) {
                    // displayArea.setText(patient.getPatientInf());
                    rovers.addPatient(patient);
                    FileWriter r = new FileWriter("text.txt");
                    r.write("patient"+patient+"\n");
                    r.flush();
                    r.close();

                    displayArea.setText("Patient added");

                } else
                    displayArea.setText("Patient not added");

            }
            catch (Exception ex){
                //System.out.print(e.toString());
            }

        }
        else if (e.getSource() == Back)
           // this.dispose();
         new FirstForm().setVisible(true);

      //  else if (e.getSource() == search)

    }
}
