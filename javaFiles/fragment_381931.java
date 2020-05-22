package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.test.AttendanceDate;

public class AssignmentUpload implements Comparable{

    private String fileName;
    private String url;
    private String year;
    private String title;

    private String instructions;
    private AttendanceDate attendanceDate;
    private String subjectName;
    private String uploadedBy;
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getInstructions() {
        return instructions;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    public AttendanceDate getAttendanceDate() {
        return attendanceDate;
    }
    public void setAttendanceDate(AttendanceDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }
    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    public String getUploadedBy() {
        return uploadedBy;
    }
    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public int compareTo(Object o) {

        AssignmentUpload au = (AssignmentUpload)o;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");



        int day = attendanceDate.getDay();
        int mon = attendanceDate.getMonth();
        int year = attendanceDate.getYear();

        int oday = au.getAttendanceDate().getDay();
        int omon = au.getAttendanceDate().getMonth();
        int oyear = au.getAttendanceDate().getYear();

        try {
            Date date = sdf.parse(day+"/"+mon +"/"+year);
            Date odate = sdf.parse(oday+"/"+omon +"/"+oyear);

            return date.compareTo(odate);

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return 0;
    }



}