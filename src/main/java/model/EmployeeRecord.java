package model;

import java.util.Date;

/* Employee Record
 * @author Ravi Kant
 * version 1.0
 * since 03-03-2022
 */

public class EmployeeRecord {
    private int id;
    private String employeeName;
    private Date dob;
    private String gender;
    private String contact;
    private String email;
    private String post;
    private String qualification;
    EmployeeAddressRecord empAddress;

    //Default Constructor
    public EmployeeRecord() {

    }

    //Parametrized Constructor
    public EmployeeRecord(String employeeName, Date dob, String gender, String contact, String email, String post, String qualification) {
        this.employeeName = employeeName;
        this.dob = dob;
        this.gender = gender;
        this.contact = contact;
        this.email = email;
        this.post = post;
        this.qualification = qualification;
    }

    //Parametrized Constructor with Employee Address
    public EmployeeRecord(String employeeName, Date dob, String gender, String contact, String email, String post, String qualification, EmployeeAddressRecord empAddress) {
        this.employeeName = employeeName;
        this.dob = dob;
        this.gender = gender;
        this.contact = contact;
        this.email = email;
        this.post = post;
        this.qualification = qualification;
        this.empAddress = empAddress;
    }

    //Parametrized Constructor with Email and Employee Address for Update Employee Address
    public EmployeeRecord(String email, EmployeeAddressRecord empAddress) {
        this.email = email;
        this.empAddress = empAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int i) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public EmployeeAddressRecord getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(EmployeeAddressRecord empAddress) {
        this.empAddress = empAddress;
    }

    @Override
    public String toString() {
        return "EmployeeRecord{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", post='" + post + '\'' +
                ", qualification='" + qualification + '\'' +
                ", empAddress=" + empAddress +
                '}';
    }
}
