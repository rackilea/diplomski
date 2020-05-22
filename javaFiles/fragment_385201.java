Object o = new String("Hi"); //will work because Object is parent class of String 
o.trim(); // can't call/will give compilation error because parent Object does not know child String's trim()
if(o.getClass().equals(String.class) ){ // check actual runtime class of o
            String ss = (String) o; //typecasting
            System.out.println(ss.trim()); // will work on String object
        }