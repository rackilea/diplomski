File f = new File("somefile.txt"); // Get the file
List<String> lines_list = Files.readAllLines(f.toPath()); // read the file
StringBuilder str = new StringBuilder(); // the file is a list, lets create a string
lines_list.forEach(str::append); // add all of the lines to the string builder
final String fileString = str.toString(); // finally create a string from it.

long startTime = System.nanoTime();
lines_list.forEach(item -> item = item.replaceAll("\\^([0-9]+)", "<sup>$1</sup>"));
long endTime = System.nanoTime();
System.out.println("Iterating and replacing over list: "+(endTime - startTime));

startTime = System.nanoTime();
fileString.replaceAll("\\^([0-9]+)", "<sup>$1</sup>");
endTime = System.nanoTime();
System.out.println("Replacing the entire string: "+(endTime - startTime));