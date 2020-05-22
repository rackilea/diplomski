private String CLINIC_NAME, CLINIC_CODE,  UNIT_NO
    ,BLDG_NAME, STREET, COUNTRY, LATITUDE, LONGITUDE, LANDLINE, MOBILE, FAX;


public MapConstants()
{

}

public MapConstants (String ClinicName, String ClinicCode, String UnitNo, String BuildingName
        , String Street, String Country, String Latitude, String Longitude, String Landline, String Mobile, String Fax)
{

    CLINIC_NAME = ClinicName;
    CLINIC_CODE = ClinicCode;
    UNIT_NO = UnitNo;
    BLDG_NAME = BuildingName;
    STREET = Street;
    COUNTRY = Country;
    LATITUDE = Latitude;
    LONGITUDE = Longitude;
    LANDLINE = Landline;
    MOBILE = Mobile;
    FAX = Fax;
}

public String setClinicName() {
    return this.CLINIC_NAME;
}

public String getClinicName() {
    return this.CLINIC_NAME;
}

public String setClinicCode() {
    return this.CLINIC_CODE;
}

public String getClinicCode() {
    return this.CLINIC_CODE;
}

public String setUnitNo() {
    return this.UNIT_NO;
}

public String getUnitNo() {
    return this.UNIT_NO;
}

public String setBldgName() {
    return this.BLDG_NAME;
}

public String getBldgName() {
    return this.BLDG_NAME;
}

public String setStreet() {
    return this.STREET;
}

public String getStreet() {
    return this.STREET;
}

public String setCountry() {
    return this.COUNTRY;
}

public String getCountry() {
    return this.COUNTRY;
}

public String setLatitude() {
    return this.LATITUDE;
}

public String getLatitude() {
    return this.LATITUDE;
}

public String setLongitude() {
    return this.LONGITUDE;
}

public String getLongitude() {
    return this.LONGITUDE;
}

public String setMobile(){
    return this.MOBILE;
}

public String getMobile(){
    return this.MOBILE;
}

public String setLandline(){
    return this.LANDLINE;
}

public String getLandline(){
    return this.LANDLINE;
}

public String setFax(){
    return this.FAX;
}

public String getFax(){
    return this.FAX;
}