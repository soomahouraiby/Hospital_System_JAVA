package Hospital;


import java.time.LocalDate;
import java.time.Period;

public class Person {
        private String First_Name;
        private String Midel_Name;
        private String Last_Name;
        private String Sur_Name;
        private String Phone;
        private String E_mail;
        private String City;
        private String Sex;
        private String Identity_No;
        private int age;
        private final int Y;
        private final int M;
        private final int D;

        public Person() {
            Y=0;
            M=0;
            D=0;
        }

        public Person(String First_Name, String Midel_Name, String Last_Name,
                      String Sur_Name, String Phone, String E_mail, String City, String Sex,
                      String Identity_No,int Y,int M,int D) {
            this.First_Name = First_Name;
            this.Midel_Name = Midel_Name;
            this.Last_Name = Last_Name;
            this.Sur_Name = Sur_Name;
            this.Phone = Phone;
            this.E_mail = E_mail;
            this.City = City;
            this.Sex = Sex;
            this.Identity_No = Identity_No;
            this.Y=Y;
            this.M=M;
            this.D=D;
        }

        public Person(int Y,int M,int D){
            this.Y=Y;
            this.M=M;
            this.D=D;
        }
        public void setFirst_Name(String first_Name) {
            First_Name = first_Name;
        }

        public void setMidel_Name(String midel_Name) {
            Midel_Name = midel_Name;
        }

        public void setLast_Name(String last_Name) {
            Last_Name = last_Name;
        }

        public void setSur_Name(String sur_Name) {
            Sur_Name = sur_Name;
        }

        public void setPhone(String phone) {
            Phone = phone;
        }

        public void setE_mail(String e_mail) {
            E_mail = e_mail;
        }

        public void setCity(String city) {
            City = city;
        }

        public void setSex(String sex) {
            Sex = sex;
        }

        public void setIdentity_No(String identity_No) {
            Identity_No = identity_No;
        }

        public String getFirst_Name() {
            return First_Name;
        }

        public String getMidel_Name() {
            return Midel_Name;
        }

        public String getLast_Name() {
            return Last_Name;
        }

        public String getSur_Name() {
            return Sur_Name;
        }

        public String getName() {
        return First_Name+Midel_Name+Last_Name+Sur_Name;
        }

        public String getPhone() {
            return Phone;
        }

        public String getE_mail() {
            return E_mail;
        }

        public String getCity() {
            return City;
        }

        public String getSex() {
            return Sex;
        }

        public String getIdentity_No() {
            return Identity_No;
        }

        public int getAge() {
            Age();
            return age;
        }

        public void Age(){

               LocalDate today = LocalDate.now();
               LocalDate birthday=LocalDate.of(Y,M,D);
               Period p= Period.between(birthday,today);
               age=p.getYears();
           // System.out.println(age);
        }
        public String toString() {
            return "Name:" + getFirst_Name() +" " + getMidel_Name() +" "+
                     getLast_Name()+" " +  getSur_Name() +
                    "\n Phone:" + getPhone() + "\n E_mail:" + getE_mail() +
                    "\n City:" + getCity() + "\n Sex:" + getSex() +
                    "\n Identity_No:" + getIdentity_No() + "\n age:" + getAge();

        }


    }