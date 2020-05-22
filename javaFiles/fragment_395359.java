String s = " August 05   July 09   May 07   April 01   March 19   February 19   January 15   December 17   December 04   December 03   December 02   November 24   October 30";
for (byte b : s.getBytes("UTF-8"))
    System.out.printf("%02x ", b);
System.out.println();
for (byte b : s.getBytes("UTF-8"))
    System.out.print(b >= 32 ? (char)b + "  " : "?  ");
System.out.println();