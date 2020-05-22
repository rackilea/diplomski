public static class ContactInfo {
    private String name;
    private PhoneNumber phoneNumber;

    public String getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

public static class PhoneNumber {
    private String work;

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}

public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

    // POJO
    ContactInfo info1 = new ContactInfo();
    info1.setName("Neel1");
    PhoneNumber num = new PhoneNumber();
    num.setWork("123 456 7890");
    info1.setPhoneNumber(num);

    String json = new ObjectMapper().defaultPrettyPrintingWriter().writeValueAsString(info1);
    System.out.println(json);

    // From JSON
    String info2Json = "{ \"name\" : \"Neel2\", \"phoneNumber\" : { \"work\" : \"098 765 4321\" } }";
    ContactInfo info2 = new ObjectMapper().readValue(info2Json, ContactInfo.class);

    doSomething(new ContactInfo[] { info1, info2 });
}

private static void doSomething(ContactInfo[] result) {
    for(ContactInfo each : result) {
        String name = each.getName();
        String workPhone = each.getPhoneNumber().getWork();
        doSomething(name, workPhone);
    }

}

private static void doSomething(String name, String workPhone) {
    System.out.println("name: " + name + ", work: " + workPhone);
}