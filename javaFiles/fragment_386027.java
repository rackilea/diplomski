Calendar cal = Calendar.getInstance();  
cal.add(Calendar.DAY_OF_MONTH, 1 * -1);  
Date yesterday = cal.getTime();   
System.out.println(yesterday);       

// Test for newer files (2nd param [false] = get newer files)        
String[] files = dir.list( new AgeFileFilter(yesterday,false) );
for ( int i = 0; i < files.length; i++ ) {
    System.out.println(files[i]);
}