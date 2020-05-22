public class RequestMode {

}

public class OobResponse {

}

public class Unknown {

    public OobResponse RequestOobRequest(
            String ClientName,
            String SecurityLink,
            short LenofHHU,
            RequestMode RequestMode){
        return new OobResponse(); // or null, whatever since it is a stub
    }
}