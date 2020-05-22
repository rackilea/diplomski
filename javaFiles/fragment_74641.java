Integer i1=new Integer(1);
Integer i2=new Integer(1);
String s1=new String("Today");
String s2=new String("Today");

// do i1 and 12 point at the same location in memory?  No - they used "new"
System.out.println(i1==i2);

// do s1 and s2 point at the same location in memory?  No - the used "new"
System.out.println(s1==s2);

// do s1 and s2 contain the same sequence of characters ("Today")?  Yes.
System.out.println(s1.equals(s2));

// do s1 and s2 point at different locations in memory?  Yes - they used "new"
System.out.println(s1!=s2);

// do s1 and s2 point to different locations in memory?  Yes - they used "new".  
// Do not check s1.equals(s2) because the first part of the || was true.
System.out.println( (s1!=s2) || s1.equals(s2));

// do s1 and s2 point at the same location in memory?  No - they used "new".  
// do not check s1.equals(s2) because the first part of the && was false.
System.out.println( (s1==s2) && s1.equals(s2));

// do s1 and s2 not contain the same sequence of characters ("Today")?  No.   
System.out.println( ! (s1.equals(s2)));