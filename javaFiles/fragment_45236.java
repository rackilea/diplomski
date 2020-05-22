public static void main(String[] args) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    MyBean bean = new MyBean("123-45-6789");

    System.out.println(mapper.writerWithView(Views.ShowSSN.class)
                             .writeValueAsString(bean));
    // results in {"ssn":"123-45-6789"}

    System.out.println(mapper.writeValueAsString(bean));
    // results in {"ssn":"xxx-xx-xxxx"}
}