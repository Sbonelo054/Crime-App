package com.example.crimeapp.Model;

public class UserDetails {
    private String Email;
    private String UserName;
    private long Password;
    private double latitude;
    private double longitude;

    public UserDetails(String UserName, String email, long password, double latitude, double longitude) {
        UserName=this.UserName;
        Email = email;
        Password = password;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public long getPassword() {
        return Password;
    }

    public void setPassword(long password) {
        Password = password;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
