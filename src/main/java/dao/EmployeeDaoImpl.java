package dao;


import model.EmployeeAddressRecord;
import model.EmployeeRecord;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
   //jdbc Template
    private JdbcTemplate jdbcTemplate;

    //Save Emploee Details
    @Override
    public int saveEmployee(EmployeeRecord empRecord) {
        String query = "insert into employee(employeeName,dob,gender,contact,email,post,qualification,street,city,pin,state,country)values(?,?,?,?,?,?,?,?,?,?,?,?)";
        int status = this.jdbcTemplate.update(query,empRecord.getEmployeeName(),empRecord.getDob(),empRecord.getGender(),
                empRecord.getContact(),empRecord.getEmail(),empRecord.getPost(),empRecord.getQualification(),
                empRecord.getEmpAddress().getStreet(),empRecord.getEmpAddress().getCity(),empRecord.getEmpAddress().getPin(),
                empRecord.getEmpAddress().getState(),empRecord.getEmpAddress().getCountry());
        return status;
    }

    //Search Employee By Email
    @Override
    public EmployeeRecord getEmployee(String empEmail) {
        String query = "select * from employee where email=?";
        RowMapper<EmployeeRecord> rowMapper = new RowMapperImpl();
        EmployeeRecord employeeRecord = this.jdbcTemplate.queryForObject(query,rowMapper,empEmail);
        return employeeRecord;
    }

    //Delete Employee
    @Override
    public int empDelete(String empEmail) {
        String query = "delete from employee where email=?";
        int status = this.jdbcTemplate.update(query,empEmail);
        return status;
    }

    //Update Employee Address By Email
    @Override
    public int empAddress(String empEmail, EmployeeRecord empRecord) {

        String query = "update employee set street=?,city=?,pin=?,state=?,country=? where email=?";
        int status = this.jdbcTemplate.update(query,empRecord.getEmpAddress().getStreet(),empRecord.getEmpAddress().getCity(),
                empRecord.getEmpAddress().getPin(),empRecord.getEmpAddress().getState(),empRecord.getEmpAddress().getCountry(),empEmail);

        return status;
    }

    //Update Emploee Info By Email
    @Override
    public int updateEmp(EmployeeRecord empRecord) {
        String query = "update employee set employeeName=?,dob=?,gender=?,contact=?,post=?,qualification=? where email=?";
        int status = this.jdbcTemplate.update(query,empRecord.getEmployeeName(),empRecord.getDob(),
                empRecord.getGender(),empRecord.getContact(),empRecord.getPost(),empRecord.getQualification(),empRecord.getEmail());

        return status;
    }

    //Search All Employee
    @Override
    public List<EmployeeRecord> getAllEmp() {
        String query = "select * from employee";
        List<EmployeeRecord> employeeRecords = this.jdbcTemplate.query(query,new RowMapperImpl());
        return employeeRecords;
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}