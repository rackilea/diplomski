package com.instance.main;
import com.instance.target.Clasa;

    public class Test{

        public static void main(String[] args) {

        Clasa targetClass;
        Object[] object=new Object[10];
        for(int i=0;i<object.length;i++){
            object[i]=new Clasa();
        }

        System.out.println("Number of Instantiate Object {Before Calling GC}: "+Clasa .getNumberOfInstatiateObj());

        /* Here I am trying to deallocate the memory of Object at index no 9, so that GC   called this unused object to deallocate it from memory*/
        for(int i=0;i<object.length;i++){
            if(i==8){
                object[i]=object[i+1];
                object[i+1]=null;
                System.runFinalization();
                System.gc();
            }
        }   

        }
    }