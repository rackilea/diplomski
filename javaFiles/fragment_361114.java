String[] attributes = {"Title", "Callsign", "Identifier"};
String itemString = "Random (X)";
if (itemString.contains("(X)")) {
    itemString = itemString.replace(
                "(X)", 
                attributes[new Random().nextInt(((attributes.length - 1) - 0) + 1) + 0]
            );
}
System.out.println(itemString);
Item r2 = new Item(itemString, 500);