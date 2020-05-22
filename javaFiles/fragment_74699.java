public void read(String message) {
    A a = objectMapper.readValue(message);

    if(a.getName() != null) {
        // This object is older version of class A
        System.out.println("Name: " + a.getName());
        metric.emit("OldObjectA", 1);
    } else {
        // This object is newer version of class A
        System.out.println("Name: " + a.getFirstName() + " " + a.getSecondName())
    }
}