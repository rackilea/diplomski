public class CalculateMark {

 int mark=0;
 public static CalculateMark calc = new CalculateMark();

    private CalculateMark() {
    }

    public static CalculateMark getInstance(){
        return calc;
    }

    public void addMark(boolean x){
    // x is true if answer is right
        if(x){
            mark+=50;

        }
         System.out.println(mark);
    }

}