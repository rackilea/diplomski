int codedMessage[] = {334, 384, 105, 222, 61, 2, 175, 228, 114, 235, 241, 
                      213, 206, 3, 321, 152, 214, 137, 224};

for (int i=0; i < codedMessage.length; ++i) {
    if (codedMessage[i] > 99) {
        String value = String.valueOf(codedMessage[i]);
        String valueReversed = new StringBuilder(value).reverse().toString();
        codedMessage[i] = Integer.parseInt(valueReversed);
    }
}

System.out.print("{");
for (int i=0; i < codedMessage.length; ++i) {
    if (i > 0) { System.out.print(", "); }
    System.out.print(codedMessage[i]);
}
System.out.print("}");