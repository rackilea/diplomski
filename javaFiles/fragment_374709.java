public class TestClass {
    public static void main(String[] args) {

        // Create a HashMap object called constants
        Map<String, String> constants = new HashMap<String, String>();

        // Add keys and values (code, constant)
        constants.put("code1", "constant1");
        constants.put("code2", "constant2");
        constants.put("code3", "constant3");
        constants.put("code4", "constant4");

        System.out.println(constants); 

        Row row  = loadRow();
        String code = loadCode();

        //How to use it
        String result = getCodeValue(row, code);

        System.out.println(result); 
    }


    // Now you get the code from the Map
    private String getCodeValue(Row row, String code) {
        return row.getString(constants.get(code));
    }
}