package Hospital;


import java.time.LocalDate;
import java.util.Scanner;

public class Patient_Data extends Person {
        private final String Medical_record_ID;
        LocalDate today = LocalDate.now();
        private static int r = 100;
        private String Zip_code;
        private String Social_status;
        public Patient_Data(){this.Social_status=null;
        this.Medical_record_ID=null;}
        public Patient_Data(String fn, String mn, String ln,
                            String sn, String ph, String em, String c, String s,
                            String ino,int y,int m,int d,String Zip_code,String Social_status) {
            super(fn, mn, ln, sn, ph, em, c, s, ino, y, m, d);
            Medical_record_ID = today.getYear()+" "+r;
            r++;
            this.Zip_code=Zip_code;
            this.Social_status=Social_status;
        }

        public Patient_Data(int y,int m,int d){
            super(y,m,d);
            Medical_record_ID = today.getYear()+" "+r;
            r++;
        }
        public void setZip_code(String zip_code) {
            Zip_code = zip_code;
        }

        public void setSocial_status(String social_status) {
            Social_status = social_status;
        }

        public String getMedical_record_ID() {
            return Medical_record_ID;
        }

        public String getZip_code() {
            return Zip_code;
        }

        public String getSocial_status() {
            return Social_status;
        }

        public String getPatientInf() {
            //System.out.println(super.toString());
                  return  "Medical_record_ID:" + getMedical_record_ID()+"\n" +super.toString()+
                           "\nZip_code:" + getZip_code() +
                           "\nSocial_status:" + getSocial_status() ;
        }
        public void Search(){
            Scanner in=new Scanner(System.in);
            String s;
            System.out.print("Enter your name ");
            s=in.next();
            if(s.equals(super.getPhone())|| s.equals(super.getIdentity_No()))
                System.out.print(getPatientInf());
        }
        public void Edit(){
            Scanner in=new Scanner(System.in);
            String s;
            System.out.print("Enter your name ");
            s=in.next();
            if(s.equals(super.getPhone())|| s.equals(super.getIdentity_No())||s.equals(super.getName()+""+"")||
                    s.equals(Medical_record_ID)){
                System.out.print("First name");
                String fname=in.next();
                System.out.print("Midel name");
                String mname=in.next();
                System.out.print("last name");
                String lname=in.next();
                System.out.print("Sur name");
                String sname=in.next();
                System.out.print("Sex");
                String sx=in.next();
                System.out.print("Phone");
                String ph=in.next();
                System.out.print("Email");
                String e=in.next();
                System.out.print("City");
                String c=in.next();
                System.out.print("Social status");
                String ss=in.next();
                System.out.print("Zip code");
                String zc=in.next();
                super.setFirst_Name(fname);
                super.setMidel_Name(mname);
                super.setLast_Name(lname);
                super.setSur_Name(sname);
                super.setSex(sx);
                super.setPhone(ph);
                super.setE_mail(e);
                super.setCity(c);
                setSocial_status(ss);
                setZip_code(zc);
            }
        }

    }