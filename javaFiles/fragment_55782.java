public final class Person {

   final private  String personFirstName;
   final private  String personLastName;
   final private ConcurrentMap<Double,String> phoneMessages;

    public Person(String firstname, String lastname) {
       this.phoneMessages = new ConcurrentHashMap<Double,String> ();
       this.personFirstName = firstname;
       this.personLastName  = lastname;
    }

    private Person(String firstname, String lastname, ConcurrentHashMap<Double,String> phoneMessages) {
       this.personFirstName = firstname;
       this.personLastName  = lastname;
       this.phoneMessages = phoneMessages;
    }

    public Person add(Double Key, String item){
        ConcurrentHashMap<Double, String> newMap = new ConcurrentHashMap<>(this.phoneMessages);
        newMap.put(Key, item);
        return new Person(this.personFirstName, this.personLastName, newMap);
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public Map<Double, String> getPhoneMessages() {
        return Collections.unmodifiableMap(this.phoneMessages);
    }

}