int lineCount = 0;
while (scanner.hasNextLine()) {
   String line = scanner.nextLine().trim();
   if (!line.isEmpty()) {
     lineCount++;
   }
}