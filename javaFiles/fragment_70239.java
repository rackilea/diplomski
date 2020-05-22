public class Basics5 extends Basics415{   

    public static void main(){
        // accessing a static method in a static context.
        Basics415.main_hooo();

        // accessing an instance method in a static context.
        final Basics415 b = new Basics415();
        b.main_ho();
    }       
}