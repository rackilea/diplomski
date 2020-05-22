package test;

import com.google.common.math.LongMath;

public class Test {

    public static void main(String[] args) throws  Exception {
        System.out.println(LongMath.class.getProtectionDomain().getCodeSource().getLocation().toURI());
    }
}