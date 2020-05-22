public class ThirdPartyResponse {   
    MetaData meta;
    Response response;
}

public class Response {
    List<Location> locations;
}

public class MetaData {
    String code;
    String requestId;    
}

public class Location {
    String id;
    String name;
    Contact contact;
    LocationDetails location;
}

public class Contact {
    String phone;
    String email;
}

public class LocationDetails {
    List<String> address;
}