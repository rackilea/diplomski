String valueStr = dataIn.readLine();
int value = Integer.parseInt(valueStr);
boolean found = false;

for (int i = 0; i < array.length; i++) {
    if (array[i] == value) {
        System.out.println("The index number is " + i);
        found = true;
        break;
    }
}
if (!found) {
    System.out.println("Error");
}