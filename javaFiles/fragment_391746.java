String line = in.nextLine();
while (!"done".equals(line)) {
     String[] arr = line.split(" ");

     // Process the line

     if (!in.hasNextLine()) {
         // Error reached end of file without finding done
     }

     line = in.nextLine();
}