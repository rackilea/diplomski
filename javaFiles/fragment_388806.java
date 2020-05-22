1. Integer age1 = p1.getAge();
       Integer != int
       Integer = Integer.valueOf(int)
   Integer age1 = Integer.valueOf(p1.getAge());

2. p1.getAge().compareTo(p2.getAge());
       int.compareTo(int)
       ^^^
       // it's just a primitive type, as a result - the compile error

3. ((Integer) p1.getAge()).compareTo(p2.getAge())
       Integer.compareTo(int)
       Integer.compareTo(Integer.valueOf(int))
   ((Integer) p1.getAge()).compareTo(Integer.valueOf(p2.getAge()))

4. (Integer) p1.getAge() ---> Integer.valueOf(p1.getAge()) 
       // why so? look at callOfCode's answer