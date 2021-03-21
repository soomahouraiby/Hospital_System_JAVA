package Hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by HP on 28/12/18.
 */
public class Add_Patient extends JDialog implements ActionListener{
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
    private JTextField y,m,d;
    private JTextField  Zip_code;
    private JTextField Social_status;
    private Patient_Data Patient;
    public Add_Patient(String sTitle, JFrame owner)
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
        add (new JLabel("Enter Birth date:"));
        add (new JLabel("Y"));
        y = new JTextField(5) ;
        add (y);
        add (new JLabel("M"));
        m = new JTextField(3) ;
        add (m);
        add (new JLabel("D"));
        d = new JTextField(3) ;
        add (d);
        add (new JLabel("Enter Zip_code:       "));
        Zip_code = new JTextField(20) ;
        add (Zip_code);
        add (new JLabel("Enter Social_status:       "));
        Social_status = new JTextField(20) ;
        add (Social_status);
        ok = new JButton("OK");
        ok.addActionListener(this);
        add(ok);
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        add(cancel);
    }
    public Patient_Data getPatient()
    {
        return Patient ;
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == ok)
        {
            // use the entered data
            int day = Integer.parseInt(d.getText());
            // validation should take place here
            Patient =  new Patient_Data(Firstname.getText()+" ",Midalname.getText()+" ",Lastname.getText()+" ",Surname.getText()+"\t",
                    Phone.getText()+"\t",E_mail.getText()+"\t",City.getText()+"\t",Sex.getText()+"\t",Identity_no.getText()+"\t",
                    Integer.parseInt(y.getText()),Integer.parseInt( m.getText()),day,"\t"+Zip_code.getText()+"\t",Social_status.getText());
        }
        else if (e.getSource() == cancel)
            // data entry cancelled
            Patient = null;
        dispose();
    }
    }

