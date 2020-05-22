String lastKey = null;
for (String str : array) {
   String[] parts = str.split(" ");
   if (parts[0].equals(lastKey)) {
       System.out.print(" ");
   } else if (lastKey != null) {
       System.out.println();
   }
   System.out.print(parts[1]);
   lastKey = parts[0];
}
System.out.println();