public class BarkingDog {
public static boolean bark(boolean barking, int hourOfDay){
if(barking==true) {
    if (hourOfDay < 8 || hourOfDay > 22) {
        return true;
    } else if (hourOfDay < 0 || hourOfDay > 23) {
        return false;
    } else {
        return false;
    }
}
else{
        return false;
    }
}
public static void main(String args[]){
    System.out.println(bark(true,1));
}
}