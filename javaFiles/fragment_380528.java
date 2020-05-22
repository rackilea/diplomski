package stackoverflow.questions;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import stackoverflow.questions.q18123430.Q18123430.ObjectA;

public class Test {

   public static class Wrapper {

      String Effect;
      String RuleID;

      @Override
      public String toString() {
         return "Wrapper [Effect=" + Effect + ", RuleID=" + RuleID + "]";
      }

   }

   public static void main(String[] args) {

      String json = "[ { \"Effect\": \"Deny\",  \"RuleID\": \"Rule1\" }, { \"Effect\": \"Deny\",  \"RuleID\":  \"Rule2\"  }]";
      Type listType = new TypeToken<List<Wrapper>>() {}.getType();

      Gson g = new Gson();
      List<Wrapper> list = g.fromJson(json, listType);
      for (Wrapper w : list)
         System.out.println(w);

   }
}