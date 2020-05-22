public void write(int id, String firstName, String secondName) {
    A a = new A();
    a.setId(id);
    a.setFirstName(firstName);
    a.setSecondName(secondName);
    bufferedWriter.write(objectMapper.writeValueAsString(a));
}