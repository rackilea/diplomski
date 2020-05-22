//It will return "Not Available" if value is null you can set your default value
public static String getValue(String value){
    return TextUtils.isEmpty(value)? "Not Available" : value  
}
//You can override it like this too.
public static String getValue(String value, String defaultValue){
    return TextUtils.isEmpty(value)? defaultValue : value  
}