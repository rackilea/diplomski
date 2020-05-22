Map<Integer, String> lineMap = new HashMap<Integer, String>();
int i = 1;
while ((strLine = br.readLine()) != null && !checker) {
    lineMap.put(i, strLine);
    // do what you want
    // if you are in line 8 (i=8)
    // get my line 4 (lineMap.get(4))
    i++;
}