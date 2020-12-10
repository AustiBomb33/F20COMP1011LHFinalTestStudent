package Models;

import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private int id;
    private double pounds, heightInCM;
    private String gender, firstName, lastName, streetAddress, city, province, postalCode, emailAddress, ccType, bloodType, phoneNumber;
    ArrayList<Product> purchases;

        public Customer(int id, double pounds, double heightInCM, String gender, String firstName, String lastName, String streetAddress, String city, String province, String postalCode, String emailAddress, String ccType, String bloodType, String phoneNumber, Product[] purchases){
setId(id);
        setPounds(pounds);
        setHeightInCM(heightInCM);
        setGender(gender);
        setFirstName(firstName);
        setLastName(lastName);
        setStreetAddress(streetAddress);
        setCity(city);
        setProvince(province);
        setPostalCode(postalCode);
        setEmailAddress(emailAddress);
        setCcType(ccType);
        setBloodType(bloodType);
        setPhoneNumber(phoneNumber);
        this.purchases = new ArrayList();
        setPurchases(purchases);
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public void setCcType(String ccType) {
        this.ccType = ccType;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHeightInCM(double heightInCM) {
        this.heightInCM = heightInCM;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPounds(double pounds) {
        this.pounds = pounds;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setPurchases(Product[] purchases) {
        Arrays.asList(purchases).forEach(product -> {
            this.purchases.add(product);
        });
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public ArrayList<Product> getPurchases() {
        return purchases;
    }

    public double getHeightInCM() {
        return heightInCM;
    }

    public double getPounds() {
        return pounds;
    }

    public int getId() {
        return id;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getCcType() {
        return ccType;
    }

    public String getCity() {
        return city;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getProvince() {
        return province;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public double getTotalPurchases(){
            return getPurchases().stream().mapToDouble(Product::getSalePrice).sum();
    }

    public double getTotalSavings(){
            return getPurchases().stream().mapToDouble(Product::getRegularPrice).sum() - getTotalPurchases();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", pounds=" + pounds +
                ", heightInCM=" + heightInCM +
                ", gender='" + gender + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", ccType='" + ccType + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", Purchases=" + purchases +
                '}';
    }
}