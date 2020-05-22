package sampleclass;

import java.util.ArrayList;
import java.util.List;

public class SampleClass {

   public static void functionExample(List<String> obj){
      obj.add("something");
      obj.add("nothing");

      System.out.println(obj);

   }

   public static void main(String[] args) {
      List<String> obj = new ArrayList<>();

      functionExample(obj);
   }
}