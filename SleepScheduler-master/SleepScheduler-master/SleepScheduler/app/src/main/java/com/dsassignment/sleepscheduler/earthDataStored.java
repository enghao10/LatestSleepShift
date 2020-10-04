package com.dsassignment.sleepscheduler;

public class earthDataStored {
    private static String date;
    private static String time;
    private static String age;
    private static String countryFrom;
    private static String countryTo;

    public earthDataStored() {
    }

    public earthDataStored(String date, String time, String age, String countryFrom, String countryTo) {
        this.date = date;
        this.time = time;
        this.age = age;
        this.countryFrom = countryFrom;
        this.countryTo = countryTo;
    }

    @Override
    public String toString() {
        return "earthDataStored{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", age='" + age + '\'' +
                ", countryFrom='" + countryFrom + '\'' +
                ", countryTo='" + countryTo + '\'' +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCountryFrom() {
        return countryFrom;
    }

    public void setCountryFrom(String countryFrom) {
        this.countryFrom = countryFrom;
    }

    public String getCountryTo() {
        return countryTo;
    }

    public void setCountryTo(String countryTo) {
        this.countryTo = countryTo;
    }
}
