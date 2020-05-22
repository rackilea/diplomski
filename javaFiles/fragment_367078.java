int toFormat = 1563992;
String output = "" + toFormat;
int counter = 0;
for (int index = output.length() - 1; index > 0; index--){
    counter++;
    if (counter % 3 == 0){
        counter = 0;
        output = output.subString(0,index) + "," + output.subString(index);
    }
}

output += " USD"; // or whatever you want
System.out.println(output);