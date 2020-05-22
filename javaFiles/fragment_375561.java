System.out.print("Enter integer: ");
String val = input.next();

System.out.print("Enter type (=, <, >): ");
String operator = input.next();

while(file.hasNextLine()){
    String line = file.nextLine();
    if(operator.equals("=") && line.contains(val)){ //check if operator is equals and if line contains entered value
        System.out.println(line);//if so, write the current line to the console.
    }else if(operator.equals(">")){//check if operator is greater than
        String integersInLine = line.replaceAll("[^0-9]+", " ");//we now set this to a new String variable. This variable does not affect the 'line' so the output will be the entire line.
        String[] strInts = integersInLine.trim().split(" "))); //get all integers in current line
        for(int i = 0; i < strInts.length; i++){//loop through all integers on the line and check if any of them fit the operator
            int compare = Integer.valueOf(strInts[i]);
            if(Integer.valueOf(val) > compare)System.out.println(line);//if the 'val' entered by the user is greater than the first integer in the line, print the line out to the console.
            break;//exit for loop to prevent the same line being written twice.
        }
    }//im sure you can use this code to implement the '<' operator also
}