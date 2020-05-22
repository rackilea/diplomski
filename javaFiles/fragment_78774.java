Boolean[][] tst = new Boolean[5][5];  
Object obj = tst;       

Boolean[][] mass;     
mass = (Boolean[][])obj;

System.out.println("tst.length = " + mass.length );
System.out.println("tst[0].length = " + mass[0].length );