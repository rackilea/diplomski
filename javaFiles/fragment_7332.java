String s = reader.readLine();
String[] allNumbers = s.split(" ");
for(String number : allNumbers) {
    int currentNumber = Integer.parseInt(number);
    bWriter.write(String.valueOf(currentNumber * 10) + " ");
}