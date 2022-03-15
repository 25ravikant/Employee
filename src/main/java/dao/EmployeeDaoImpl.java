package dao;

import connection.MySqlConnection;
import model.EmployeeAddressRecord;
import model.EmployeeRecord;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
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
        Configuration cfg = new Configuration();
        //Hibernate configuration file
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        //getting session object from session factory
        Session session = sessionFactory.openSession();
       try {
           //getting transaction object from session object
           Transaction trx = session.beginTransaction();

           session.save(empRecord);
           trx.commit();

           session.close();
       }catch (HibernateException ex){
           ex.printStackTrace();
        }
       finally {
           if(session!= null) {
               session.close();
               sessionFactory.close();
           }
       }
        return status;
    }

// Search Employee By Email
    @Override
    public List<EmployeeRecord> getEmployee(String empEmail) {
        List<EmployeeRecord> employeeRecords = null;
        Configuration cfg = new Configuration();
        //Hibernate configuration file
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        //getting session object from session factory
        Session session = sessionFactory.openSession();
        try {
            employeeRecords = session.createQuery("from EmployeeRecord where email='" + empEmail + "' ").list();

            session.close();

        }catch (HibernateException ex) {
            ex.printStackTrace();
        }finally {
            if(session!= null) {
                session.close();
                sessionFactory.close();
            }
        }
        return employeeRecords;

      }

//Delete Employee By Employee Email
    @Override
    public int empDelete(String empEmail) {
        int status =0;
        Configuration cfg = new Configuration();
        //Hibernate configuration file
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        EmployeeRecord employeeRecord = new EmployeeRecord();

        //getting session object from session factory
        Session session = sessionFactory.openSession();

        //getting transaction object from session object
        Transaction trx = session.beginTransaction();
        try {


            session.createQuery("delete from EmployeeRecord where email='" + empEmail + "' ").executeUpdate();

            trx.commit();
            session.close();

        }catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            if(session!= null) {
                session.close();
                sessionFactory.close();
            }
        }
        return status;
    }

    //Update Employee Address By Email
    @Override
    public int empAddress(String empEmail,EmployeeRecord empRec) {
        int status =0;
        Configuration cfg = new Configuration();

        //Hibernate configuration file
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        //getting session object from session factory
        Session session = sessionFactory.openSession();

        //getting transaction object from session object
        Transaction trx = session.beginTransaction();
        try {
            status = session.createQuery("update from EmployeeRecord set street='" + empRec.getEmpAddress().getStreet() + "'," +
                    "city='" + empRec.getEmpAddress().getCity() + "',pin='" + empRec.getEmpAddress().getPin() + "'," +
                    "state='" + empRec.getEmpAddress().getState() + "',country='" + empRec.getEmpAddress().getCountry() + "' where email='" + empEmail + "'").executeUpdate();

            trx.commit();
            session.close();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            if(session!= null) {
                session.close();
                sessionFactory.close();
            }
        }
        return status;
    }

    //Update Employee Info By Email
    @Override
    public int updateEmp(EmployeeRecord empRecord) {
        int status =0;
        Configuration cfg = new Configuration();

        //Hibernate configuration file
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        //getting session object from session factory
        Session session = sessionFactory.openSession();

        //getting transaction object from session object
        Transaction trx = session.beginTransaction();
          try {
              status = session.createQuery("update from EmployeeRecord set employeeName='" + empRecord.getEmployeeName() + "'," +
                      "gender='" + empRecord.getGender() + "',contact='" + empRecord.getContact() + "',post='" + empRecord.getPost() + "'" +
                      " where email='" + empRecord.getEmail() + "'").executeUpdate();

              trx.commit();
              session.close();
          } catch (HibernateException ex) {
              ex.printStackTrace();
          }  finally {
              if(session!= null) {
                  session.close();
                  sessionFactory.close();
              }
          }

        return status;
    }

    //Search All Employee
    @Override
    public List<EmployeeRecord> getAllEmp() {
        List<EmployeeRecord> employeeRecords = null;
        Configuration cfg = new Configuration();
        //Hibernate configuration file
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        //getting session object from session factory
        Session session = sessionFactory.openSession();
        //getting transaction object from session object

       Transaction trx = session.beginTransaction();
          try {
              employeeRecords = session.createQuery("from EmployeeRecord").list();
              trx.commit();
              session.close();
          } catch (HibernateException ex) {
              ex.printStackTrace();
          }  finally {
              if(session!= null) {
                  session.close();
                  sessionFactory.close();
              }
          }
        return employeeRecords;

    }

}
