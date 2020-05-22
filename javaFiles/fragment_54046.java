int min = Integer.MAX_VALUE;
int max = -1;
for(int x=0; x<=loop_num;x++){ 

    System.out.println("Enter the number of daylight hrs for day "+ x);
    int next_num = new_scan.nextInt();

    if(next_num>max){
        max = next_num;
    } 
    if (nex_num <min) {
        min = nex_num;
    }

}
System.out.println("The lowest amount of sunlight of the days given was: "+ min);
System.out.println("The highest amount of sunlight of the days given was: "+ max);