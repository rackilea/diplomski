static Integer count = 0;

public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(getEmployeeIdBy("DILIP","","DURAISWAMY"));
    System.out.println(getEmployeeIdBy("KUTTY","","DILIP"));
    System.out.println(getEmployeeIdBy("PANDA","R","SADASIBA"));

}

public static String getEmployeeIdBy(String firstName, String middleName, String lastName) {

    String res1 = firstName.substring(0, 3);
    String res2 = middleName.isEmpty() ? "0" : middleName.substring(0, 1);
    String res3 = lastName.substring(0, 3);
    String res4 = res1 + res2 + res3;
    String res5 = count.toString().length() == 1 ? ("00" + count)
            : count.toString().length() == 2 ? ("0" + count) : count.toString();
    count = count + 1;
    String finalResult = res4 + res5;
    return finalResult;

}`