public class HelloWorld{


class Student {
    int marks;
}


public static void main(String []args){

        Student studentArray[] = new Student[2];
        studentArray[0] = new Student(); // .marks = 100;
        studentArray[1] = new Student(); // .marks = 75;
        studentArray[0].marks = 100;
        studentArray[1].marks = 75;

        int m=0;
        m = studentArray[0].marks;

        System.out.println(m);
    }
}