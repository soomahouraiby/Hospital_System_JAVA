package Hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by HP on 30/12/18.
 */
public class MedicalForm extends JFrame implements ActionListener {
    private JButton displayMedical;
    private JButton addMedical;
    private JButton Back;
    private JTextArea displayArea;
    private Patient_file rovers;

    public MedicalForm() {
        setTitle("My frame");
        setBounds(100, 100, 400, 400);

        // Adding some sample data

       /* Patient_Data Ali = new Patient_Data("Ali","Saleh","Ahmed","Alglal","777342345","AliAlglal@gmail",
                "Sana","Male","001000233467",2000,10,30," sana111","Married");
        Patient_Data Amal = new Patient_Data("Amal","Muneer","Ahmed","Alglal","777356745","AmalAlglal@gmail",
                "Sana","Female","001000275467",1990,5,2," sana133","Student");*/

        rovers = new Patient_file(2018,12,30,30);
       // rovers.addPatient(Ali);
       // rovers.addPatient(Amal);

        //rovers.addDoctor(Ali);
        //rovers.addDoctor(Amal);
        getContentPane().setLayout(new BorderLayout());
        // add controls and actionListeners
        displayMedical = new JButton("Display all Medical file");
        displayMedical.addActionListener(this);
        addMedical = new JButton("Add new Medical File");
        addMedical.addActionListener(this);
        Back = new JButton("Back");
        Back.addActionListener(this);

        JPanel p = new JPanel();
        p.add(displayMedical);
        p.add(addMedical);
        p.add(Back);
        getContentPane().add("North", p);

        JPanel northPanel = new JPanel();
        displayArea = new JTextArea("This is the display area    " +
                "\nDetails of Medical file will be displayed here      " +
                "\nPlease make your choice\n\n\n");
        JScrollPane scrollPane;
        scrollPane = new JScrollPane(displayArea);
        northPanel.add(scrollPane);
        getContentPane().add("Center", northPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == displayMedical) {
            // display all players
            rovers.details(displayArea);
        } else if (e.getSource() == addMedical) {
            Add_Patient dlg =
                    new Add_Patient("Add a new Medical  Dialog", this);
            dlg.setVisible(true);
            Patient_Data patient = dlg.getPatient();
            if (patient != null) {
                displayArea.setText(patient.getPatientInf());
                rovers.addPatient(patient);
                displayArea.setText("Medical file added");
            } else
                displayArea.setText("Medical file not added");
        }
        else if (e.getSource() == Back)
            new FirstForm().setVisible(true);
    }
}
