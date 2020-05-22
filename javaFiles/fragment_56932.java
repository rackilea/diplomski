String input = scanner.nextLine();
String integers[] = input.split(" ");
if(integers.length > 13 || integers.length < 1){
    //ErrorHandling
}
for(String number : integers){
    try {
        int num = Integer.parseInt(number);
        //Add to array
    } catch(NumberFormatException e){
        //number String input was not a number
    }
}