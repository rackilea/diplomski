public class Example {

    private static final String FILE1 = "firstName,lastName\nJohn,Smith\nSally,Jones";
    private static final String FILE2 = "age,sex\n21,male\n24,female";
    private static final String FILE3 = "city,country\nBrisbane,Australia\nBerlin,Germany";
    private static final List<String> DESIRED_HEADERS = Arrays.asList("firstName", "sex", "country");

    @Test
    public void testMultipleFiles() throws Exception {

        try (
            ICsvBeanReader reader1 = new CsvBeanReader(new StringReader(FILE1), CsvPreference.STANDARD_PREFERENCE);
            ICsvBeanReader reader2 = new CsvBeanReader(new StringReader(FILE2), CsvPreference.STANDARD_PREFERENCE);
            ICsvBeanReader reader3 = new CsvBeanReader(new StringReader(FILE3), CsvPreference.STANDARD_PREFERENCE);){

            String[] mapping1 = getNameMappingFromHeader(reader1);
            String[] mapping2 = getNameMappingFromHeader(reader2);
            String[] mapping3 = getNameMappingFromHeader(reader3);

            Person person;
            while((person = reader1.read(Person.class, mapping1)) != null){
                reader2.read(person, mapping2);
                reader3.read(person, mapping3);
                System.out.println(person);
            }
        } 

    }

    private String[] getNameMappingFromHeader(ICsvBeanReader reader) throws IOException{
        String[] header = reader.getHeader(true);

        // only read in the desired fields (set unknown headers to null to ignore)
        for (int i = 0; i < header.length; i++){
            if (!DESIRED_HEADERS.contains(header[i])){
                header[i] = null;
            }
        }

        return header;
    }
}