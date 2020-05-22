package com.rizze.test.labs.sof;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class SOF {    

    public static class Link {
        public String name;
        public int id;

        public static Link build(String n, int i){
            Link l = new Link();
            l.name = n;
            l.id=i;
            return l;
        }

        public String toString(){
            return String.format("[%s , %d]", name,id);
        }           
    }       

    @Test
    public void test() {

        List<Link> links = new ArrayList<Link>();

        //SSETUP [[A, 1], [C, 2], [D, 1], [D, 2]]
        links.add(Link.build("D", 1));
        links.add(Link.build("A", 1));
        links.add(Link.build("D", 2));
        links.add(Link.build("C", 2));


        Collections.sort(links, new Comparator<Link>() {    
            @Override
            public int compare(Link p1, Link p2) {
                int ret = p1.name.compareTo(p2.name);
                if(ret == 0) {
                    ret= p1.id - p2.id;
                }
                return ret;             
            }               
        });
        System.out.println(links);          
    }    
}