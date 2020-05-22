while (reader.hasNextLine()) {          
    for (i = 0; i < image_width * image_height ; i++) {             
        int p = (a << 24) | (r << 16) | (g << 8) | b;

        for (x = 0; x < image_width && reader.hasNext(); x++) {
            char c = reader.next().charAt(i);