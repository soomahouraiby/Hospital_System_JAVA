package Hospital;

import javax.swing.*;
import java.util.ArrayList;

public class Booking {
    private static int Appointment_no = 0;
    private static int orderdoctor = 0;

    private int Waiting_no;
    final int Y;
    final int M;
    final int D;
    // private Payment_meathod pay;
    private Patient_Data patient;
    private Doctor_Data doctor;
    private double percent;
    private int maxBooking=30;
    private int maxDoctor=10;
    ArrayList<Patient_Data> x = new ArrayList<Patient_Data>(maxBooking);
    ArrayList<Doctor_Data> z = new ArrayList<Doctor_Data>(maxDoctor);

  /*  public Booking(int Y, int M, int D,int n) {

        this.Y = Y;
        this.M = M;
        this.D = D;
        maxBooking=n;
        Appointment_no++;
    }*/
    public Booking(int Y, int M, int D) {

        this.Y = Y;
        this.M = M;
        this.D = D;
        Appointment_no++;
        orderdoctor++;
    }

   /* public String getBooking(Patient_Data patient, String s) {
        if (s.equals(patient.getPhone()) || s.equals(patient.getIdentity_No())) {
            String p = "Doctor name: " + doctor.getName() + "\nPatient name:" + patient.getName() + "\nWaiting_no:" + Waiting_no +
                    "\n Appointment_no:" + Appointment_no + "\nAppointment date:" + Y + "/" + M + "/" + D;
            return p;
        }
        return null;
    }*/

    public boolean addPatient(Patient_Data newPatient) {   // add another patient
        if (Appointment_no == maxBooking)
        {
            return false;
        } else {   // add patient
            x.add(newPatient);
            Appointment_no++;
            return true;
        }
    }

    public boolean addDoctor(Doctor_Data newDoctor) {   // add another doctor
        if (orderdoctor == maxDoctor)
        {
            return false;
        } else {   // add patient
            z.add(newDoctor);
            orderdoctor++;
            return true;
        }
    }

    public int getAppointment_NO() {
        return Appointment_no;
    }

    public int getWaiting_no() {
        return Waiting_no;
    }

    public void setWaiting_no(int Waiting_no) {


        this.Waiting_no = Waiting_no;
    }

   /* public int getMaxBooking() {
        return maxBooking;
    }

    public void setMaxBooking(int MaxBooking) {


        this.maxBooking = maxBooking;
    }

    public int getMaxDoctor() {
        return maxDoctor;
    }

    public void setMaxDoctor(int MaxDoctor) {


        this.maxDoctor = maxDoctor;
    }*/

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double Required_to_pay(int n) {
        double sum = percent * n;
        return sum;
    }


   public void details(JTextArea displayArea) {
       displayArea.setText("Appointment_no: " + Appointment_no );
       displayArea.append("\nThe patients:");
       for(int i=0;i<x.size();i++)
       {

           displayArea.append("\n" +"order= "+(i+1)+"\n"+x.get(i).getPatientInf());
       }
   }
    public void details1(JTextArea displayArea) {
        displayArea.setText("Number_Doctors: " + orderdoctor );

        displayArea.append("\nThe Doctors:");
        for(int i=0;i<z.size();i++)
        {

            displayArea.append("\n" +"order= "+(i+1)+"\n"+z.get(i).getDoctorinf());
        }
    }
}
