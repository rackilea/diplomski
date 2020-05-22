int num=1351280;
 int ones = (num % 10)/1;
 int tens = (num-ones) % 100;
 int hun = (num-(tens+ones)) % 1000;
 int thou = (num-(tens+ones+hun)) % 10000;
 int tenThou = (num-(tens+ones+hun+thou)) % 100000;
 int hunThou = (num-(tens+ones+hun+thou+tenThou)) % 1000000;
 int mil  = (num-(tens+ones+hun+thou+tenThou+hunThou)) % 10000000;

 System.out.println(mil);
 System.out.println(hunThou);
 System.out.println(tenThou);
 System.out.println(thou);
 System.out.println(hun);
 System.out.println(tens);
 System.out.println(ones);