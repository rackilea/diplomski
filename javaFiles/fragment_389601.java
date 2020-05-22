public enum CountryCode {
   US,
   GB,
   CA;
}

@ValidateString(CountryCode.STRING) 
String code;