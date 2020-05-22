-----------------------------------com.example.Context.java-----------------------------------

package com.example;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Context {

@SerializedName("location")
@Expose
private Location location;
@SerializedName("accessToken")
@Expose
private String accessToken;
@SerializedName("notificationToken")
@Expose
private String notificationToken;
@SerializedName("requestTime")
@Expose
private Integer requestTime;
@SerializedName("application")
@Expose
private String application;
@SerializedName("version")
@Expose
private Integer version;

/**
* 
* @return
* The location
*/
public Location getLocation() {
return location;
}

/**
* 
* @param location
* The location
*/
public void setLocation(Location location) {
this.location = location;
}

/**
* 
* @return
* The accessToken
*/
public String getAccessToken() {
return accessToken;
}

/**
* 
* @param accessToken
* The accessToken
*/
public void setAccessToken(String accessToken) {
this.accessToken = accessToken;
}

/**
* 
* @return
* The notificationToken
*/
public String getNotificationToken() {
return notificationToken;
}

/**
* 
* @param notificationToken
* The notificationToken
*/
public void setNotificationToken(String notificationToken) {
this.notificationToken = notificationToken;
}

/**
* 
* @return
* The requestTime
*/
public Integer getRequestTime() {
return requestTime;
}

/**
* 
* @param requestTime
* The requestTime
*/
public void setRequestTime(Integer requestTime) {
this.requestTime = requestTime;
}

/**
* 
* @return
* The application
*/
public String getApplication() {
return application;
}

/**
* 
* @param application
* The application
*/
public void setApplication(String application) {
this.application = application;
}

/**
* 
* @return
* The version
*/
public Integer getVersion() {
return version;
}

/**
* 
* @param version
* The version
*/
public void setVersion(Integer version) {
this.version = version;
}

}
-----------------------------------com.example.Location.java-----------------------------------

package com.example;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Location {

@SerializedName("longt")
@Expose
private Integer longt;
@SerializedName("lat")
@Expose
private Integer lat;
@SerializedName("radius")
@Expose
private Integer radius;

/**
* 
* @return
* The longt
*/
public Integer getLongt() {
return longt;
}

/**
* 
* @param longt
* The longt
*/
public void setLongt(Integer longt) {
this.longt = longt;
}

/**
* 
* @return
* The lat
*/
public Integer getLat() {
return lat;
}

/**
* 
* @param lat
* The lat
*/
public void setLat(Integer lat) {
this.lat = lat;
}

/**
* 
* @return
* The radius
*/
public Integer getRadius() {
return radius;
}

/**
* 
* @param radius
* The radius
*/
public void setRadius(Integer radius) {
this.radius = radius;
}

}
-----------------------------------com.example.Request.java-----------------------------------

package com.example;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Request {

@SerializedName("application")
@Expose
private String application;
@SerializedName("version")
@Expose
private Integer version;

/**
* 
* @return
* The application
*/
public String getApplication() {
return application;
}

/**
* 
* @param application
* The application
*/
public void setApplication(String application) {
this.application = application;
}

/**
* 
* @return
* The version
*/
public Integer getVersion() {
return version;
}

/**
* 
* @param version
* The version
*/
public void setVersion(Integer version) {
this.version = version;
}

}
-----------------------------------com.example.VersionDTO.java-----------------------------------

package com.example;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class VersionDTO {

@SerializedName("context")
@Expose
private Context context;
@SerializedName("request")
@Expose
private Request request;

/**
* 
* @return
* The context
*/
public Context getContext() {
return context;
}

/**
* 
* @param context
* The context
*/
public void setContext(Context context) {
this.context = context;
}

/**
* 
* @return
* The request
*/
public Request getRequest() {
return request;
}

/**
* 
* @param request
* The request
*/
public void setRequest(Request request) {
this.request = request;
}

}