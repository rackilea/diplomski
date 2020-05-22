case 5:
   //  Scanner user_input = new Scanner( System.in );
System.out.println("Enter the Rental Threshold: ");
threshold = user_input.next();
for(int i=0;i<array.length;i++){
if(Integer.valueOf(threshold)>array[i])
System.out.println("Month "+(i+1)+" has the rent falling below the threshold range as the rent is "+array[i]);
}
System.out.println("");
break;