for(int i=0;i<number.length;i++){
    try{
        sum+=Integer.parseInt(number[i]);
    }
    catch( Exception e ) {

    }
}
System.out.println("The sum is:"+sum);