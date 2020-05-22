while(true){  //infinite loop
    out.println("Enter positive number to add, 0 to stop.");
    input = in.nextInt();
    if(input == 0)
        break;
    if(input > 0)
        sum+= input;
}
return sum;