int num = year; //to preserve the original year value
     int digit = num / 1000; //get first digit
     //check if digit is 0 or 1
     num = num % 1000; //remove first digit
     digit = num / 100; //get second digit
     //check if digit is 0 or 1
     num = num % 100;//remove second digit
     etc