int sum = 0;

String inputString = "5 10 20 10 5";
String []arr = inputString.split(" ");

for (String str : arr) {
    sum += Integer.parseInt(str);   //+= here
}

System.out.println("Average is " + (double) sum / arr.length);