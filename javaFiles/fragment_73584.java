private String callType;

....
public boolean isNational(){

    if (callType.compareTo("National")==0)
        return true;
    else
        return false;
}

public boolean isInternational(){

    if (callType.compareTo("international")==0)
        return true;
    else
        return false;
}