package com.test;
import java.util.ArrayList;

public class MyArrayList<P> extends ArrayList<Pair> {
    public static void main(String[] args) {
       Pair p1 = new Pair ("A", 2);
       Pair p2 = new Pair ("B", 4);
       Pair p3 = new Pair ("C", 1);

       MyArrayList<Pair> l1 = new MyArrayList<Pair>();
       l1.add(p1);
       l1.add(p2);
       l1.add(p3);

       Pair p4 = new Pair ("A", 5);
       Pair p5 = new Pair ("C", 10);
       Pair p6 = new Pair ("D", 12);

       ArrayList<Pair> l2 = new ArrayList<Pair>();
       l2.add(p4);
       l2.add(p5);
       l2.add(p6);

       l1.merge(l2);
       System.out.println(l1.toJson());

    }

   @Override
   public boolean add(Pair e) {
       Pair p = this.getPair(e);
       if (p == null) return super.add(e);
       p.value += e.value;
       return true;
   }

   public void merge (ArrayList<Pair> list) {
       for(Pair p : list) this.add(p);
   }

   public String toJson() {
       StringBuffer s = new StringBuffer("[");
       for(Pair p : this) s.append("{\"name\":").append("\"").append(p.name).append("\",").append("\"value\":").append(p.value).append("},");
       return s.append("]").deleteCharAt(s.length()-2).toString();
   }

   private Pair getPair (Pair e) {
       for(Pair p : this) if (p.name.equals(e.name)) return p;
       return null;
   }
}