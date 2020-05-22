String delimiter = " ";

String line = scan.nextLine();              // "Colored pencils 3 0.59"

int last = line.lastIndexOf(delimiter);     // "Colored pencils 3_0.59"

String price = line.substring(last + 1);    // "0.59"

line = line.substring(0, last);             // "Colored pencils 3"

last = line.lastIndexOf(delimiter);         // "Colored pencils_3"

String quantity = line.substring(last + 1); // "3"

line = line.substring(0, last);             // "Colored pencils"

String product = line;