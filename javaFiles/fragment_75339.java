double x = 0;
while(line != null) {

    float percent = lineNumber * 100f / totalLines;
    if (Math.round(percent) != x) {
         System.out.println(x + "% read.");
         x = Math.round(percent);
    }
    line = reader.readLine();

    lineNumber++;   
}