package Hospital;


import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Scanner;

public class Doctor_Data extends Person {
    private final String Doctor_ID;
    LocalDate today = LocalDate.now();
    private static int x = 1000;
    private String[] Days;
    public String[] time;
    public Doctor_Data(){
        this.Doctor_ID=null;}
    public Doctor_Data(String fn, String mn, String ln,
                       String sn, String ph, String em, String c, String s,
                       String ino,int y,int m,int d) {
        super( fn, mn, ln, sn, ph, em, c, s, ino,y, m, d);
        Doctor_ID = today.getYear() +" "+ x;
        x++;
    }
    public Doctor_Data(int y,int m,int d){
        super(y,m,d);
        Doctor_ID = today.getYear()+" "+x;
        x++;
    }
    public String getDoctor_ID() {
        return Doctor_ID;
    }

    public void setDays(String[] Days) {

        this.Days = Days;
    }

    public void setTime(String[] time) {
        this.time = time;
    }

    public String[] getDays() {

        return Days;
    }

    public String[] getTime() {
        return time;
    }

    public void printdays(){
        for(String s: Days)
            System.out.print(s+"     ");

    }

    public void printtime(){
        for(String s: time)
            System.out.print(s+"     ");
    }
    public String[] printAppointment()
    {
        String [] Appointment=new String[Days.length];
        if(Days.length!=time.length) {
            System.out.print("The two arrays not equals");
            return Appointment;
        }
        else
            for(int i=0;i<Days.length;i++){
                Appointment[i]=" ";
                Appointment[i]+=Days[i]+" "+time[i];
                return Appointment;}
        for(String s: Appointment)
            System.out.println(s);
        return Appointment;
    }
    public String getDoctorinf(){
       // System.out.print(super.toString());
        return "Doctor_ID: "+Doctor_ID+"\n"+super.toString();
    }
    public void Search(String s){
        if(s.equals(super.getPhone())|| s.equals(super.getIdentity_No()))
            System.out.print(getDoctorinf());
    }
    public void Edit(String s) {
        Scanner in = new Scanner(System.in);
        if (s.equals(super.getPhone()) || s.equals(super.getIdentity_No())) {
            System.out.print("First name\t");
            String fname = in.next();
            System.out.print("Midel name\t");
            String mname = in.next();
            System.out.print("last name\t");
            String lname = in.next();
            System.out.print("Sur name\t");
            String sname = in.next();
            System.out.print("Sex\t");
            String sx = in.next();
            System.out.print("Phone\t");
            String ph = in.next();
            System.out.print("Email\t");
            String e = in.next();
            System.out.print("City\t");
            String c = in.next();
            super.setFirst_Name(fname);
            super.setMidel_Name(mname);
            super.setLast_Name(lname);
            super.setSur_Name(sname);
            super.setSex(sx);
            super.setPhone(ph);
            super.setE_mail(e);
            super.setCity(c);

        }
    }
}