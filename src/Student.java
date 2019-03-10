//taken from SQL Database
public class Student {

    //fields
    private int StudentID;
    private String name, email,password,gender,address;

    public Student(int studentID, String name, String email, String password, String gender, String address) {
        StudentID = studentID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.address = address;
    }
    //getters and setters
    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        StudentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
@Override
    public String toString(){
        return (getStudentID()+" "+getName()+" "+getEmail()+" "+
                getPassword()+" "+getGender()+" "+getAddress()+"\n");

    }
}//end studentClass
