String range = "-2100--2000, 100-200, 500, 1000-1200, 2000-2100";
System.out.println(inRange(range, -2150)); // false
System.out.println(inRange(range, -2000)); // true
System.out.println(inRange(range, 400));   // false
System.out.println(inRange(range, 500));   // true
System.out.println(inRange(range, 1100));  // true