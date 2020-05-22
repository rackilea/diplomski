package it.unica.pr2.pizze;
import java.util.ArrayList;
import java.util.*;

public class Pizza extends ArrayList   {

    public Pizza(Ingrediente[] ing) {

        for(Ingrediente elem: ing) {

            this.add(elem);
        }

    }

    public int calorie() {
        int calorie = 0;
        for(Object i : this) {
            calorie += ((Ingrediente)i).getCalorie();
        }
        return calorie;
    }


}