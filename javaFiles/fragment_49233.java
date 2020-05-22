String s ="panLast412345";
String[] res = s.split("(?<!^panLast(?=4)|^nm(?=14)|^nm1(?=4))(?=[0-9]+$)", 2);
if ( res.length==2 ) {
    System.out.println("name: " + res[0]);
    System.out.println("ID: " + res[1]); 
}