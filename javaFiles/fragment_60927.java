int sum = 0;
String[] parts = output.split("\\s+");

for (String part : parts) {
    sum += Integer.parseInt(part);
}