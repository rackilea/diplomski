int sum = 300;
while (sum >= 200 && sum <= 300 ) {
    if((sum % 11 == 0) != (sum % 13 == 0)) { //checks if sum is a multiple of 11 or 13 but not both
        System.out.println(sum);
    }
    sum = sum - 1;  
}