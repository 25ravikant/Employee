package model;



/* Employee Address Record
 * @author Ravi Kant
 * @version 1.0
 * @since 03-03-2022
 */

public class EmployeeAddressRecord {
    private String street;
    private String city;
    private String pin;
    private String state;
    private String country;

    //Default Constructor
    public EmployeeAddressRecord() {
    }

    //Parametrized Constructor
    public EmployeeAddressRecord(String street, String city, String pin, String state, String country) {
        this.street = street;
        this.city = city;
        this.pin = pin;
        this.state = state;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    //toString Method
    @Override
    public String toString() {
        return "EmployeeAddressRecord{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", pin='" + pin + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
