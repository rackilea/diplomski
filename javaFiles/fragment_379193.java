package com.prime_components; public class LRP_model implements Serializable {
    private String uid;
    private String lrpName;
    private String lrpDesc;
    private String lrpStartpoint;
    String lrpSLat;
    String lrpSLng;
    private String lrpEndpoint;
    String lrpELat;
    String lrpELng;
    private String lrpDistance;
    private String lrpSubRegion;
    private String lrpRegion;
    private String userId;
    private ArrayList<Route_model> route_models;

    public LRP_model(){}
    public LRP_model(String uid, String lrpName, String lrpDesc, String lrpStartpoint, String lrpSLat, String lrpSLng, String lrpEndpoint, String lrpELat, String lrpELng, String lrpDistance, String lrpSubRegion, String lrpRegion, String userId, ArrayList<Route_model>route_models) {
        this.uid = uid;
        this.lrpName = lrpName;
        this.lrpDesc = lrpDesc;
        this.lrpStartpoint = lrpStartpoint;
        this.lrpSLat = lrpSLat;
        this.lrpSLng = lrpSLng;
        this.lrpEndpoint = lrpEndpoint;
        this.lrpELat = lrpELat;
        this.lrpELng = lrpELng;
        this.lrpDistance = lrpDistance;
        this.lrpSubRegion = lrpSubRegion;
        this.lrpRegion = lrpRegion;
        this.userId = userId;
        this.route_models = route_models;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setLrpName(String lrpName) {
        this.lrpName = lrpName;
    }

    public void setLrpDesc(String lrpDesc) {
        this.lrpDesc = lrpDesc;
    }

    public void setLrpStartpoint(String lrpStartpoint) {
        this.lrpStartpoint = lrpStartpoint;
    }

    public void setLrpSLat(String lrpSLat) {
        this.lrpSLat = lrpSLat;
    }

    public void setLrpSLng(String lrpSLng) {
        this.lrpSLng = lrpSLng;
    }

    public void setLrpEndpoint(String lrpEndpoint) {
        this.lrpEndpoint = lrpEndpoint;
    }

    public void setLrpELat(String lrpELat) {
        this.lrpELat = lrpELat;
    }

    public void setLrpELng(String lrpELng) {
        this.lrpELng = lrpELng;
    }

    public void setLrpDistance(String lrpDistance) {
        this.lrpDistance = lrpDistance;
    }

    public void setLrpSubRegion(String lrpSubRegion) {
        this.lrpSubRegion = lrpSubRegion;
    }

    public void setLrpRegion(String lrpRegion) {
        this.lrpRegion = lrpRegion;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUid() {
        return uid;
    }

    public String getLrpName() {
        return lrpName;
    }

    public String getLrpDesc() {
        return lrpDesc;
    }

    public String getLrpStartpoint() {
        return lrpStartpoint;
    }

    public String getLrpSLat() {
        return lrpSLat;
    }

    public String getLrpSLng() {
        return lrpSLng;
    }

    public String getLrpEndpoint() {
        return lrpEndpoint;
    }

    public String getLrpELat() {
        return lrpELat;
    }

    public String getLrpELng() {
        return lrpELng;
    }

    public String getLrpDistance() {
        return lrpDistance;
    }

    public String getLrpSubRegion() {
        return lrpSubRegion;
    }

    public String getLrpRegion() {
        return lrpRegion;
    }

    public String getUserId() {
        return userId;
    }

    public ArrayList<Route_model> getRoute_models(){
        return  route_models;
    }

    public void setRoute_models(ArrayList<Route_model> route_models){
        this.route_models = route_models;
    }

}