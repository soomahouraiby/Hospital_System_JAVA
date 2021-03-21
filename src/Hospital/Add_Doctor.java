package Hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by HP on 28/12/18.
 */
public class Add_Doctor extends JDialog implements ActionListener {
    private JButton ok;
    private JButton cancel ;
    private JTextField Firstname ;
    private JTextField Midalname ;
    private JTextField Lastname ;
    private JTextField Surname ;
    private JTextField Phone;
    private JTextField E_mail;
    private JTextField City;
    private JTextField Sex;
    private JTextField Identity_no;
    private JTextField y;
    private JTextField m;
    private JTextField d;
    private Doctor_Data Doctor;
    public Add_Doctor(String sTitle, JFrame owner)
    {
        super (owner, sTitle, true);
        setLayout(new FlowLayout());
        setSize(300,600);
        add (new JLabel("Enter First name:    "));
        Firstname = new JTextField(20) ;
        add (Firstname);
        add (new JLabel("Enter Midal name:    "));
        Midalname = new JTextField(20) ;
        add (Midalname);
        add (new JLabel("Enter Last name:    "));
        Lastname = new JTextField(20) ;
        add (Lastname);
        add (new JLabel("Enter Sur name:    "));
        Surname = new JTextField(20) ;
        add (Surname);
        add (new JLabel("Enter Phone: "));
        Phone = new JTextField(20) ;
        add (Phone);
        add (new JLabel("Enter E_mail:       "));
        E_mail = new JTextField(20) ;
        add (E_mail);
        add (new JLabel("Enter City:       "));
        City = new JTextField(20) ;
        add (City);
        add (new JLabel("Enter Sex:       "));
        Sex = new JTextField(20) ;
        add (Sex);
        add (new JLabel("Enter Identity_no:       "));
        Identity_no = new JTextField(20) ;
        add (Identity_no);
        add (new JLabel("Enter Birth date:       "));
        y = new JTextField(5) ;
        add (y);
        m = new JTextField(3) ;
        add (m);
        d = new JTextField(3) ;
        add (d);
        ok = new JButton("OK");
        ok.addActionListener(this);
        add(ok);
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        add(cancel);
    }
    public Doctor_Data getDoctor(){return Doctor;}

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == ok)
        {
            // use the entered data
            int theday= Integer.parseInt(d.getText());
            // validation should take place here
            Doctor =  new Doctor_Data(Firstname.getText(),Midalname.getText(),Lastname.getText(),Surname.getText(),
                    Phone.getText(),E_mail.getText(),City.getText(),Sex.getText(),Identity_no.getText(),
                    Integer.parseInt(y.getText()),Integer.parseInt(m.getText()),theday);
        }
        else if (e.getSource() == cancel)
            // data entry cancelled
            Doctor = null;
        dispose();
    }
}
