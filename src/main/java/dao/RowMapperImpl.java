package dao;

import model.EmployeeAddressRecord;
import model.EmployeeRecord;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImpl implements RowMapper<EmployeeRecord> {
    @Override
    public EmployeeRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeAddressRecord address = new EmployeeAddressRecord();
        EmployeeRecord employeeRecord = new EmployeeRecord();

        employeeRecord.setId(rs.getInt("id"));
        employeeRecord.setEmployeeName(rs.getString("employeeName"));
        employeeRecord.setDob(rs.getDate("dob"));
        employeeRecord.setGender(rs.getString("gender"));
        employeeRecord.setContact(rs.getString("contact"));
        employeeRecord.setEmail(rs.getString("email"));
        employeeRecord.setPost(rs.getString("post"));
        employeeRecord.setQualification(rs.getString("qualification"));
        address.setStreet(rs.getString("street"));
        address.setCity(rs.getString("city"));
        address.setPin(rs.getString("pin"));
        address.setState(rs.getString("state"));
        address.setCountry(rs.getString("country"));

        employeeRecord.setEmpAddress(address);
        return employeeRecord;
    }
}
