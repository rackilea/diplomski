package uk.co.puce4.charactercount;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;


public class CharacterCount {
public static void main(String[] args)
{ 
    TreeMap<Character,Integer> tm = new TreeMap<Character,Integer>();

    String s = "ajklfajdlkfajsdklfjalljaklsdfjaklsdjf"; 

    for (int i = 0; i < s.length(); i++) { 
        char ch = s.charAt(i); 
        int count = 1;
        if(tm.containsKey(ch)){
            count=tm.get(ch) + 1;
        }
        tm.put(ch, count);
    }

    TreeSet<CharItem> ts = new TreeSet<CharItem>(); 
    Iterator<Character> it = tm.descendingKeySet().iterator();

    while (it.hasNext()){
        char ch = (char) it.next();
        int count = tm.get(ch);
        CharItem ci= new CharItem(ch, count);
        ts.add(ci);
        }
        Iterator<CharItem> it2 = ts.iterator(); 
        while(it2.hasNext()){
            CharItem ci=it2.next();
            System.out.println(ci.getCh() + " occured " + ci.getCount() + " times"); 
        }
    }
}

class CharItem implements Comparable<CharItem>{
    private int count;
    private char ch;
    public CharItem(char c, int i){
        count = i;
        ch = c;
    }
    public char getCh() {
        return this.ch;
                }
    public int getCount() {
        return this.count;
        }

    @Override
    public int compareTo(CharItem b) {
        return b.count - this.count ;
    }
}