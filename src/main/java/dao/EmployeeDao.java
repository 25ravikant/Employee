package dao;

import model.EmployeeAddressRecord;
import model.EmployeeRecord;
import java.util.List;

/* EmployeeDao Interface
 * @author Ravi Kant
 * @version 1.0
 * @since 03-03-2022
 */

public interface EmployeeDao {

    //Save Employee
    public int saveEmployee(EmployeeRecord epmRecord);

    //Search Employee By Email
    public List<EmployeeRecord> getEmployee(String empEmail);

    //Delete Employee By Email
    public int empDelete(String empEmail);

    //Update Employee Address By Email
    public int empAddress(String empEmail, EmployeeRecord empRecord);

    //Update Employee Info
    public int updateEmp(EmployeeRecord empRecord);

    //Search All Emp
    public List<EmployeeRecord> getAllEmp();
}
