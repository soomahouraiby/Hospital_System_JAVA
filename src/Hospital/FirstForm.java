package Hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by HP on 30/12/18.
 */
public class FirstForm extends JFrame implements ActionListener {
    private JButton Patient;
    private JButton Doctor;
    private JButton Medical;
    private JTextArea displayArea;
    private Booking rovers;

    public FirstForm() {
        setTitle("Hospital");
        setBounds(100, 100, 500, 300);

        getContentPane().setLayout(new BorderLayout());
        // add controls and actionListeners
        Patient = new JButton(" patient");
        Patient.addActionListener(this);
        Doctor = new JButton("Doctor");
        Doctor.addActionListener(this);
        Medical = new JButton("Medical Record File");
        Medical.addActionListener(this);

        JPanel p = new JPanel();
        p.add(Patient);
        p.add(Doctor);
      //  p.add(Medical);
        getContentPane().add("North", p);
        JPanel northPanel = new JPanel();
        displayArea = new JTextArea("This is the display area    " +
                "\nDetails of patient or Doctor or Medical Record File" +
                "           \n  will be displayed here      " +
                "\nPlease make your choice\n\n\n");
        JScrollPane scrollPane;
        scrollPane = new JScrollPane(displayArea);
        northPanel.add(scrollPane);
        getContentPane().add("Center", northPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Patient) {
            this.dispose();
            new BookingForm().setVisible(true);
        } else if (e.getSource() == Doctor) {
            this.dispose();

            new BookingForm2().setVisible(true);
        }
        else if (e.getSource() == Medical) {
            this.dispose();

            new BookingForm2().setVisible(true);
        }
    }
}