System.out.print("Express product name that you want to remove: ");

String productName = keyboard.next();
ArrayList <Integer> rKey = null;

for (Entry <ArrayList <Integer>, String> entry: hMap.entrySet())  {
    if (productName.equals(entry.getValue())) {
        rKey = entry.getKey();
        break;
    }
}

if (rKey != null) {
    hMap.remove(rKey);
}