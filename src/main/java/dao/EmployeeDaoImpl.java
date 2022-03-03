package dao;

import connection.MySqlConnection;
import model.EmployeeAddressRecord;
import model.EmployeeRecord;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/* EmployeeDao Interface Implementing Class
 * @author Ravi Kant
 * @version 1.0
 * @since 03-03-2022
 */

public class EmployeeDaoImpl implements EmployeeDao {
//Save Emploee Details
    @Override
    public int saveEmployee(EmployeeRecord empRecord) {
       int status =0;
       Connection conn = MySqlConnection.sqlConnection();
        PreparedStatement ps = null;
       try {
           ps = conn.prepareStatement("insert into employee(employeeName,dob,gender,contactNo,email,post,qualification,street,city,pincode,state,country)values(?,?,?,?,?,?,?,?,?,?,?,?)");
           ps.setString(1,empRecord.getEmployeeName());
           java.sql.Date sqlDate=new java.sql.Date(empRecord.getDob().getTime());
           ps.setDate(2,sqlDate);
           ps.setString(3,empRecord.getGender());
           ps.setString(4,empRecord.getContact());
           ps.setString(5,empRecord.getEmail());
           ps.setString(6,empRecord.getPost());
           ps.setString(7,empRecord.getQualification());
           ps.setString(8,empRecord.getEmpAddress().getStreet());
           ps.setString(9,empRecord.getEmpAddress().getCity());
           ps.setString(10,empRecord.getEmpAddress().getPin());
           ps.setString(11,empRecord.getEmpAddress().getState());
           ps.setString(12,empRecord.getEmpAddress().getCountry());
           status = ps.executeUpdate();
       } catch (SQLException ex) {
           ex.printStackTrace();
       } finally {
           try {
               conn.close();
               ps.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       return status;
    }
// Search Employee By Email
    @Override
    public List<EmployeeRecord> getEmployee(String empEmail) {
        List<EmployeeRecord> list = new ArrayList<>();
        Connection conn = MySqlConnection.sqlConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from employee where email=?");
            ps.setString(1,empEmail);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                EmployeeRecord empRec = new EmployeeRecord();
                EmployeeAddressRecord empAdd = new EmployeeAddressRecord();
                empRec.setEmployeeName(rs.getString("employeeName"));
                empRec.setDob(rs.getDate("dob"));
                empRec.setGender(rs.getString("gender"));
                empRec.setContact(rs.getString("contactNo"));
                empRec.setEmail(rs.getString("email"));
                empRec.setPost(rs.getString("post"));
                empRec.setQualification(rs.getString("qualification"));

                empAdd.setStreet(rs.getString("street"));
                empAdd.setCity(rs.getString("city"));
                empAdd.setPin(rs.getString("pincode"));
                empAdd.setState(rs.getString("state"));
                empAdd.setCountry(rs.getString("country"));

                empRec.setEmpAddress(empAdd);
                list.add(empRec);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;

    }
//Delete Employee By Employee Email
    @Override
    public int empDelete(String empEmail) {
        int status =0;
        Connection conn = MySqlConnection.sqlConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from employee where email=?");
            ps.setString(1,empEmail);
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return status;
    }

    //Update Employee Address By Email
    @Override
    public int empAddress(String empEmail,EmployeeRecord empRec) {
        int status =0;
        Connection conn = MySqlConnection.sqlConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update employee set street=?,city=?,pincode=?,state=?,country=? where email=?");
            ps.setString(1,empRec.getEmpAddress().getStreet());
            ps.setString(2,empRec.getEmpAddress().getCity());
            ps.setString(3,empRec.getEmpAddress().getPin());
            ps.setString(4,empRec.getEmpAddress().getState());
            ps.setString(5,empRec.getEmpAddress().getCountry());
            ps.setString(6,empEmail);
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return status;
    }

    //Update Employee Info By Email
    @Override
    public int updateEmp(EmployeeRecord empRecord) {
        int status =0;
        Connection conn = MySqlConnection.sqlConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update employee set employeeName=?,dob=?,gender=?,contactNo=?,post=?,qualification=? where email=?");
            ps.setString(1,empRecord.getEmployeeName());
            java.sql.Date sqlDate=new java.sql.Date(empRecord.getDob().getTime());
            ps.setDate(2,sqlDate);
            ps.setString(3,empRecord.getGender());
            ps.setString(4,empRecord.getContact());
            ps.setString(5,empRecord.getPost());
            ps.setString(6,empRecord.getQualification());
            ps.setString(7,empRecord.getEmail());
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return status;
    }

    //Search All Employee
    @Override
    public List<EmployeeRecord> getAllEmp() {
        List<EmployeeRecord> list = new ArrayList<>();
        Connection conn = MySqlConnection.sqlConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from employee");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                EmployeeRecord empRec = new EmployeeRecord();
                EmployeeAddressRecord empAdd = new EmployeeAddressRecord();
                empRec.setEmployeeName(rs.getString("employeeName"));
                empRec.setDob(rs.getDate("dob"));
                empRec.setGender(rs.getString("gender"));
                empRec.setContact(rs.getString("contactNo"));
                empRec.setEmail(rs.getString("email"));
                empRec.setPost(rs.getString("post"));
                empRec.setQualification(rs.getString("qualification"));

                empAdd.setStreet(rs.getString("street"));
                empAdd.setCity(rs.getString("city"));
                empAdd.setPin(rs.getString("pincode"));
                empAdd.setState(rs.getString("state"));
                empAdd.setCountry(rs.getString("country"));

                empRec.setEmpAddress(empAdd);
                list.add(empRec);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


}
