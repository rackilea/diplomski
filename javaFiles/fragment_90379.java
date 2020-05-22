boolean inCE = false;

for (String line : lines) {
   if (line.contains("CE-")) {
     inCE = true;
   }
   else if (line.trim().isEmpty()) {
     inCE = false;
   }
   else if (inCE) {
     System.out.println(line);
     CE.add(line);
   }
}