public class Test {
    public static void setData6(String[] empnameList, String empname) { // with the `String array` you should declare the variable name like `empnameList` or `arrEmpname` NOT `empname` because `empname` make confusing when you read code
        this.empnameList = empnameList;
        this.empname = empname;
    }

    public static void main(String[] args) {
        String[] strArray = new String[]{"Name1","Name2","Name2"};
        String empName = "Na";

        setData6(strArray,empName); // call method with 2 parameters here
    }
}