package Hospital;


import java.util.Scanner;

public class Patient_file extends Booking{
    private static int file_no=0;
    private String Diagnosis;
    private String Scientific_name;
    private String Medication_use;
    private Patient_Data patient;
    private Doctor_Data doctor;
    static String[] Service_name;
    static int[] Cost_of_service;
    private boolean take_service;
    static int Service_no;
    Scanner in=new Scanner(System.in);

    public Patient_file( int Y,int M,int D,int Service_no) {
        super(Y,M,D);
        file_no++;
        Cost_of_service=new int [Service_no];
        Service_name=new String [Service_no];
    }

    public void  enterServices(int Service_num){
        for(int i=0;i<Service_no;i++){
            System.out.print("Enter Service name");
            Service_name[i]=in.next();
            System.out.println("Enter cost of Service");
            Cost_of_service[i]=in.nextInt();
        }
    }

    public void setScientific_name(String Scientific_name){
        this.Scientific_name= Scientific_name;
    }

    public String getScientific_name(){
        return Scientific_name;
    }
    public int getFile_no(){
        return file_no;
    }

    public String getDiagnosis(){
        return Diagnosis;
    }
    public void setDiagnosis (String Diagnosis){
        this.Diagnosis=Diagnosis;
    }

    public String getMedication_use(){
        return Medication_use;
    }
    public void setMedication_use (String Medication_use){
        this.Medication_use=Medication_use;
    }

    public void printCost_of_service(){
        for(int i :Cost_of_service)
            System.out.print(i);
    }

    public void printService_name(){
        for(String s :Service_name)
            System.out.print(Service_no+":"+s);
    }

    public void MedicalFile(){
        if(take_service){
            int n;
            printCost_of_service();
            System.out.println("Enter Service number:");
            n=in.nextInt();
            System.out.println("Patient name:"+patient.getName()
            +"\nDoctor name:"+doctor.getName()+"\nAppointment number:"+getAppointment_NO()
            +"\nAppointment date:"+Y+"/"+M+"/"+D+"\nDiagnosis:"+Diagnosis+"\nScientific_name:"+Scientific_name
            +"\nMedication_use:"+Medication_use+"\nService name:"+Service_name[n]+"Cost of Service"
                    +super.Required_to_pay(Cost_of_service[n]));
        }
        else {
            System.out.println("Patient name:"+patient.getName()
                    +"\nDoctor name:"+doctor.getName()+"\nAppointment number:"+getAppointment_NO()
                    +"\nAppointment date:"+Y+"/"+M+"/"+D+"\nDiagnosis:"+Diagnosis+"\nScientific_name:"+Scientific_name
                    +"\nMedication_use:"+Medication_use);
        }
    }
}
