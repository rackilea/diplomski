private  Map<String, String> subjectsByCodes = new HashMap<String, String>();

public void addSubject(String code, String subject){
    subjectsByCodes.put(code, subject);
}

public String getSubject(String code){
    return subjectsByCodes.get(code);
}

public int getNumberOfSubject(){
    return subjectsByCodes.getSize();
}