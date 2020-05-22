package com.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class LoopTest {

    public static void main(String[] args) {
        LoopTest lt=new LoopTest();
        int records = 200000;
        lt.execute(records, false);
        lt.execute(records, true);
        lt.executeObj(records, false);
        lt.executeObj(records, true);
        lt.executeReflect(records, false);
        lt.executeReflect(records, true);


    }

    public void execute(int loops, boolean useCapacity){
        Date start=new Date();
        System.out.println("EXAMPLE WITH HASHMAP");
        System.out.println(start+ " time: "+start.getTime()+" Start for loops="+loops+ " and useCapacity="+useCapacity);
        List<HashMap<String,String>> userData=null;
        if(useCapacity)
            userData=new ArrayList<HashMap<String,String>>(loops);
        else 
            userData=new ArrayList<HashMap<String,String>>();

        for(int i=0;i<loops;i++){
            HashMap<String,String> recordMap = new HashMap<String,String>();
            for (int j = 1; j <= 10; j++) {
                String key = j+"";
                String value = j+" val";
                recordMap.put(key, value);
            }
            userData.add(recordMap);
        }
        Date end=new Date();
        System.out.println(end+ " time: "+end.getTime()+", elapsed="+(end.getTime()-start.getTime())+" end for loops="+loops+ " and useCapacity="+useCapacity);
        System.out.println("-------------------------");

    }

    public void executeObj(int loops, boolean useCapacity){
        System.out.println("EXAMPLE WITH CLASSIC OBJECT");
        Date start=new Date();
        System.out.println(start+ " time: "+start.getTime()+" Start for loops="+loops+ ", object and useCapacity="+useCapacity);
        List<TestObj> userData=null;
        if(useCapacity)
            userData=new ArrayList<TestObj>(loops);
        else 
            userData=new ArrayList<TestObj>();

        for (int i=0;i<loops;i++){
            TestObj testObj = new TestObj();
            testObj.test1="1";
            testObj.test2="1";
            testObj.test3="1";
            testObj.test4="1";
            testObj.test5="1";
            testObj.test6="1";
            testObj.test7="1";
            testObj.test8="1";
            testObj.test9="1";
            testObj.test10="1";
            testObj.test11="1";
            testObj.test12="1";
            testObj.test13="1";
            testObj.test14="1";
            testObj.test15="1";
            testObj.test16="1";
            testObj.test17="1";
            testObj.test18="1";
            testObj.test19="1";
            testObj.test20="1";
            userData.add(testObj);
        }
        Date end=new Date();
        System.out.println(end+ " time: "+end.getTime()+", elapsed="+(end.getTime()-start.getTime())+" end for loops="+loops+ ", object and useCapacity="+useCapacity);
        System.out.println("-------------------------");

    }

    public void executeReflect(int loops, boolean useCapacity){
        System.out.println("EXAMPLE WITH REFLECTION");
        Date start=new Date();
        System.out.println(start+ " time: "+start.getTime()+" Start for loops="+loops+ ", object and useCapacity="+useCapacity);
        List<TestObj> userData=null;
        if(useCapacity)
            userData=new ArrayList<TestObj>(loops);
        else 
            userData=new ArrayList<TestObj>();



        for (int i=0;i<loops;i++){
            try{
                Class<?> objClass=Class.forName("com.test.TestObj");
                Object myObj=objClass.newInstance();


            for(int j=1;j<=20;j++){

                Field f=objClass.getDeclaredField("test"+j);
                f.set(myObj, "1");
            }
            userData.add((TestObj)myObj);

            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }



        }
        Date end=new Date();
        System.out.println(end+ " time: "+end.getTime()+", elapsed="+(end.getTime()-start.getTime())+" end for loops="+loops+ ", reflect and useCapacity="+useCapacity);
        System.out.println("-------------------------");

    }


}