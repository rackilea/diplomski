package test;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<HTTPMethodConvertible> blah = new ArrayList<>();
        blah.add(LibraryEnum.FIRST);
        blah.add(ClientEnum.BLABLABLA);
        for (HTTPMethodConvertible element: blah) {
            System.out.println(element.getHTTPMethodType());
        }
    }

    static interface HTTPMethodConvertible {
        public String getHTTPMethodType();
    }
    static enum LibraryEnum implements HTTPMethodConvertible {
        FIRST("first"),
        SECOND("second"),
        THIRD("third");
        String httpMethodType;
        LibraryEnum(String s) {
            httpMethodType = s;
        }
        public String getHTTPMethodType() {
            return httpMethodType;
        }
    }
    static enum ClientEnum implements HTTPMethodConvertible {
        FOO("GET"),BAR("PUT"),BLAH("OPTIONS"),MEH("DELETE"),BLABLABLA("POST");
        String httpMethodType;
        ClientEnum(String s){
            httpMethodType = s;
        }
        public String getHTTPMethodType() {
            return httpMethodType;
        }
    }
}