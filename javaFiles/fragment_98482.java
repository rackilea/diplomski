private static class EmployeeSerializer extends StdSerializer<Employee> {

    private static final String TYPE_ONE = "SomeType";

    private static final String TYPE_TWO = "SomeOtherType";

    private SimpleDateFormat sampleFormatOne = /** format initialized **/;

    private SimpleDateFormat sampelFormatTwo = /** format initialized **/;

    protected EmployeeSerializer() {
        super(Employee.class);
    }

    @Override
    public void serialize(Employee employee, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeString(employee.getEmployeeType());
        switch (employee.getEmployeeType()) {
            case TYPE_ONE: jsonGenerator.writeString(sampleFormatOne.format(employee.getEmpJoiningDate()));
            case TYPE_TWO: jsonGenerator.writeString(sampelFormatTwo.format(employee.getEmpJoiningDate()));
        }
        jsonGenerator.writeEndObject();
    }
}