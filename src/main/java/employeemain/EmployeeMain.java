package employeemain;


import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import model.EmployeeAddressRecord;
import model.EmployeeRecord;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*
 * EmployeeMain Class for Perform CRUD operation
 * @author   Ravi Kant
 * @version  1.0
 * @since    03-02-2022
 */
public class EmployeeMain {
    static Logger log = Logger.getLogger(EmployeeMain.class);
    public static void main(String[] args) throws ParseException {
        //Basic Configure of Log4j
        BasicConfigurator.configure();

        //create two Scanner Object
        Scanner scannerString = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        int choice =0;
        do{
            //Choose Choice to Perform Operations
            System.out.println("1. Insert Employee");
            System.out.println("2. Search By Email");
            System.out.println("3. Update Employee Address");
            System.out.println("4. Update Employee Info");
            System.out.println("5. Delete Employee");
            System.out.println("6. Search All Employee");
            System.out.print("Enter Your Choice  :");

            choice = scannerInt.nextInt();
            //switch case to choose user input
            switch (choice) {
                //Case 1 for Save Employee
                case 1:
                    //Enter Employee Name
                    System.out.print("Enter Employee Name  :");
                    String empName = scannerString.nextLine();

                    //Enter Employee Date of Birth
                    System.out.print("Enter Date of Birth (yyyy-mm-dd) :");
                    String empDob = scannerString.nextLine();
                    Date empDobDate = new SimpleDateFormat("yyyy-MM-dd").parse(empDob);

                    //Enter Employee Gender
                    System.out.print("Enter Gender  :");
                    String empGender = scannerString.nextLine();

                    //Enter Employee Contact No.
                    System.out.print("Enter Contact No.  :");
                    String empContact = scannerString.nextLine();

                    //Enter Employee Email
                    System.out.print("Enter Email  :");
                    String empEmail = scannerString.nextLine();

                    //Enter Employee Post
                    System.out.print("Enter Post  :");
                    String empPost = scannerString.nextLine();

                    //Enter Employee Qualification
                    System.out.print("Enter Qualification  :");
                    String empQualification = scannerString.nextLine();

                    //Enter Employee Street
                    System.out.print("Enter Street  :");
                    String empStreet = scannerString.nextLine();

                    //Enter Employee City
                    System.out.print("Enter City  :");
                    String empCity = scannerString.nextLine();

                    //Enter Employee Pin
                    System.out.print("Enter Pin  :");
                    String empPin = scannerString.nextLine();

                    //Enter Employee State
                    System.out.print("Enter State  :");
                    String empState = scannerString.nextLine();

                    //Enter Employee Country
                    System.out.print("Enter Country  :");
                    String empCountry = scannerString.nextLine();

                    //Employee Address Object
                    EmployeeAddressRecord empAddress = new EmployeeAddressRecord(empStreet,empCity,empPin,empState,empCountry);
                    //Employee Object
                    EmployeeRecord emp = new EmployeeRecord(empName,empDobDate,empGender,empContact,empEmail,empPost,empQualification,empAddress);
                    //Employee Dao
                    EmployeeDao empDao = new EmployeeDaoImpl();
                    empDao.saveEmployee(emp);

                    break;
                case 2:
                    System.out.print("Enter Employee Email  :");
                    String empEmail1 = scannerString.nextLine();
                    EmployeeDao emDao = new EmployeeDaoImpl();
                    List<EmployeeRecord> employeeRecords = emDao.getEmployee(empEmail1);
                    employeeRecords.forEach((n)-> System.out.println(n));
//                    employeeRecords.forEach((n)-> System.out.println(n));
                    break;
                case 3:
                    System.out.print("Enter Employee Email for Update :");
                    String empEmail2 = scannerString.nextLine();

                    System.out.print("Enter Street :");
                    String empStreet2 = scannerString.nextLine();

                    System.out.print("Enter City :");
                    String empCity2 = scannerString.nextLine();

                    System.out.print("Enter Pin  :");
                    String empPin2 = scannerString.nextLine();

                    System.out.print("Enter State  :");
                    String empState2 = scannerString.nextLine();

                    System.out.print("Enter Country  :");
                    String empCountry2 = scannerString.nextLine();

                    EmployeeAddressRecord empAdd = new EmployeeAddressRecord(empStreet2,empCity2,empPin2,empState2,empCountry2);
                    EmployeeRecord empRecord1 = new EmployeeRecord(empEmail2,empAdd);

                    EmployeeDao empDao2 = new EmployeeDaoImpl();
                    int status1 = empDao2.empAddress(empEmail2,empRecord1);
                    if(status1>0) {
                        log.info("Record has been Updated");
                    } else {
                        log.info("Record has been not Updated");
                    }
                    break;
                case 4:
                    System.out.print("Enter Employee Email for Update :");
                    String empEmail3 = scannerString.nextLine();

                    System.out.print("Enter Employee New Name :");
                    String empName1 = scannerString.nextLine();

                    System.out.print("Enter New Date of Birth (yyyy-mm-dd) :");
                    String empDob1 = scannerString.nextLine();
                    Date empDobDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(empDob1);

                    System.out.print("Enter New Gender  :");
                    String empGender1 = scannerString.nextLine();

                    System.out.print("Enter New Contact :");
                    String empContact1 = scannerString.nextLine();

                    System.out.print("Enter New Post :");
                    String empPost1 = scannerString.nextLine();

                    System.out.print("Enter New Qualification :");
                    String empQua = scannerString.nextLine();

                    EmployeeRecord empRecord3 = new EmployeeRecord(empName1,empDobDate1,empGender1,empContact1,empEmail3,empPost1,empQua);

                    EmployeeDao empDao3 = new EmployeeDaoImpl();
                    int status3 = empDao3.updateEmp(empRecord3);
                    if(status3>0) {
                        log.info("Record has been Updated");
                    } else {
                        log.info("Record has been not Updated");
                    }
                    break;

                case 5:
                    System.out.println("Enter Employee Email for Delete :");
                    String emEmail = scannerString.nextLine();
                    EmployeeDao employeeDao = new EmployeeDaoImpl();
                    employeeDao.empDelete(emEmail);

                    break;
                case 6:
                    EmployeeDao employeeDao1 = new EmployeeDaoImpl();
                    List<EmployeeRecord> employeeRecords1 = employeeDao1.getAllEmp();
                    employeeRecords1.forEach((n)-> System.out.println(n));
                    break;
                default:
                    System.out.println("");
                    break;
            }

        }while (choice !=0 );


    }
}
