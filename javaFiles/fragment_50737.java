package com.example;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ActivitiesStep {

@SerializedName("dateTime")
@Expose
private String dateTime;
@SerializedName("value")
@Expose
private String value;

/**
* 
* @return
* The dateTime
*/
public String getDateTime() {
return dateTime;
}

/**
* 
* @param dateTime
* The dateTime
*/
public void setDateTime(String dateTime) {
this.dateTime = dateTime;
}

/**
* 
* @return
* The value
*/
public String getValue() {
return value;
}

/**
* 
* @param value
* The value
*/
public void setValue(String value) {
this.value = value;
}

}
-----------------------------------com.example.Example.java-----------------------------------

package com.example;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Example {

@SerializedName("activities-steps")
@Expose
private List<ActivitiesStep> activitiesSteps = new ArrayList<ActivitiesStep>();

/**
* 
* @return
* The activitiesSteps
*/
public List<ActivitiesStep> getActivitiesSteps() {
return activitiesSteps;
}

/**
* 
* @param activitiesSteps
* The activities-steps
*/
public void setActivitiesSteps(List<ActivitiesStep> activitiesSteps) {
this.activitiesSteps = activitiesSteps;
}

}