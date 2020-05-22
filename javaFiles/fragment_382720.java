import java.util.*;
import java.io.*;
public class Random 
{ 
    private String back01;

    public static void ran(int number) {
        switch(number) {
            //All options
        }
    }

    //If you only use "setImage()" in the class is not necessary
    //declare this one as "public static"
    //public static void setImage(String back01) {
    private void setImage(String back01) {
        this.back01 = back01;
    }

    public static String getImage() {
        return back01;
    }
}