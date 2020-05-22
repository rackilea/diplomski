for (int length = 0; (length = input.read(buffer)) > 0;) 
    output2.write(buffer, 0, length);
}
((GZIPOutputStream)output2).finish(); //Write the compressed parts
// obviously make sure output2 is truly GZIPOutputStream
output2.flush(); //