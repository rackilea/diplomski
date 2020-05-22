String[] strArray = { "Truck", "Car", "Boat" };

String temp = strArray[0];

for (int i = 0; i < strArray.length - 1; i++) {
    strArray[i] = strArray[i + 1];
}

strArray[strArray.length - 1] = temp;

Arrays.stream(strArray).forEach((e) -> System.out.print(e + " "));