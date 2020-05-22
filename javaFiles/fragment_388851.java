import java.awt.MouseInfo;

public class Mouse {
    public static void main(String[] args) {
        while ( true ) {
            System.out.println( MouseInfo.getPointerInfo().getLocation() );
        }
    }
}