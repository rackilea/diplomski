import java.util.StringTokenizer;
public class Car {
    public double parseEqn(String str) {
           StringTokenizer st = new StringTokenizer(str,"+-/*%",true);
           String first = st.nextToken();
           String op = st.nextToken();
           String second = st.nextToken();
           double ff = Double.parseDouble(first);
           double ss = Double.parseDouble(second);
           double answer = 0;
           if (op.equals("+")){
           answer= ff+ss;}
           else if (op.equals("-")){
           answer= ff-ss;}
           else if (op.equals("/")){
           answer= ff/ss;}
           else if(op.equals("*")){
           answer= ff*ss;}
           return answer;
    }
    public static void main(String args[]) {
        Car c = new Car();
        System.out.println(c.parseEqn("123+23"));
        System.out.println(c.parseEqn("3+5"));
        System.out.println(c.parseEqn("3-5"));
        /* Output From Console
         * 
         * 146.0
        8.0
        -2.0*/
    }
}