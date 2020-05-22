package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class TestCode {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date today = sdf.parse("18/10/2017");

        // assuming Dates - 3/10/2017 12/9/2017 20/10/2017 21/10/2017
        String dts = "3/10/2017,12/9/2017,20/10/2017,21/10/2017";

        List<AssignmentUpload> assignmentUploadList = new ArrayList<AssignmentUpload>();
        List<AssignmentUpload> futureAssg = new ArrayList<AssignmentUpload>();
        List<AssignmentUpload> pastAssg = new ArrayList<AssignmentUpload>();
        List<AssignmentUpload> finalAssg = new ArrayList<AssignmentUpload>();

        for (String dt : dts.split(",")) {

            String[] nos = dt.split("/");
            int day = Integer.parseInt(nos[0]);
            int mon = Integer.parseInt(nos[1]);
            int year = Integer.parseInt(nos[2]);

            AttendanceDate ad = new AttendanceDate(day,mon,year);
            AssignmentUpload au = new AssignmentUpload();
            au.setAttendanceDate(ad);
            au.setSubjectName("assg - " +dt);

            assignmentUploadList.add(au);

        }

        // Now we will start with assignmentUploadList

        for (AssignmentUpload au : assignmentUploadList) {

            int day = au.getAttendanceDate().getDay();
            int mon = au.getAttendanceDate().getMonth();
            int year = au.getAttendanceDate().getYear();

            Date date = sdf.parse(day+"/"+mon +"/"+year); 

            if (date.before(today)) {
                pastAssg.add(au);
            } else {
                futureAssg.add(au);
            }

        }

        // Sort pastand future dates individually
        Collections.sort(futureAssg);
        Collections.sort(pastAssg,Collections.reverseOrder());

        // Add future Dates to final Dates first
        finalAssg.addAll(futureAssg);


        // Then Add past Dates to final Dates
        finalAssg.addAll(pastAssg);

        assignmentUploadList = finalAssg;

        for (AssignmentUpload au : assignmentUploadList) {
            System.out.println(au.getSubjectName());
        }

    }

}