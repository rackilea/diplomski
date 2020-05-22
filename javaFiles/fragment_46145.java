String[] parts = msg.split(",");
int sum = 0;
StringBuilder stringParts = new StringBuilder();
for (String part : parts) {
    try {
        sum += Integer.parseInt(part);
    } catch (NumberFormatException ex) {
        stringParts.append("," + part);
    }
}
stringParts.insert(0, String.valueOf(sum));

System.out.println(stringParts.toString()); // the final result