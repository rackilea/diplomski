public static void main(String[] args) throws Exception {

    String str1 = "https://somehost:someport/employee/v1/salaries/123/as56hgXWF";
    //String str2 = "/employee/v1/salaries/123/as56hgXWF";
    String str2 = str1.replaceAll("^http.*://[a-zA-Z0-9.:]+", "");
    String rgx = "(?<=([a-zA-Z0-9][/\\\\]))((([a-zA-Z]+)([0-9]+)([a-zA-Z0-9]*))|(([0-9]+)([a-zA-Z]+)([a-zA-Z0-9]*)))";
    System.out.println(str1.replaceAll(rgx, "XYZ")); // print ->    https://somehost:someport/employee/XYZ/salaries/123/XYZ
    System.out.println(str2.replaceAll(rgx, "XYZ")); // print ->    /employee/XYZ/salaries/123/XYZ

}