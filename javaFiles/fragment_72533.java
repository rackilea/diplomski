package edu.aspire.li;

import java.io.Serializable;

public class Student implements Serializable{
    private int sno;
    private String name;
    private String email;
    private long mobile;    

    public Student(){
        System.out.println("This is to construct student");
    }
    public int getSno() {
        return sno;
    }
    public void setSno(int sno) {
        this.sno = sno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public long getMobile() {
        return mobile;
    }
    public void setMobile(long mobile) {
        this.mobile = mobile;
    }


}