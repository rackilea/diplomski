import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String pattern = "</{0,1}\\s*(((\\w+\\s*)={0,1}(\"|'){0,1}((\\w+\\s*-*_*)*(:|;|\\)|\\()*/{0,2}(\\w*\\s*/{0,1}\\.{0,1}&*;*\\?*=*-*\\+*%*)(\"|'){0,1}))\\s*)*/{0,1}>";
        String str = "<script>alert(123)</script>";
        System.out.println(str.replaceAll(pattern, ""));
    }
}