reader.beginArray();
while (reader.hasNext()) {
    int position;
    int a, b, d; // stores your parsed values
    String c; // stores your parsed values
    reader.beginArray(); 
    // read and parse first four elements, checking hasNext() each time for robustness
    for (position = 0; position < 4 && reader.hasNext(); ++ position) {
        if (position == 0) a = reader.nextInt(); 
        else if (position == 1) b = reader.nextInt();
        else if (position == 2) c = reader.nextString();
        else if (position == 3) d = reader.nextInt();
    } 
    // if position < 4 then there weren't enough values in array.
    if (position == 4) { // correctly read 
        System.out.println(a + " " + b + " " + c + " " + d);
    }
    // skip rest of array, regardless of number of values
    while (reader.hasNext())
        reader.skipValue();
    reader.endArray();
} 
reader.endArray();