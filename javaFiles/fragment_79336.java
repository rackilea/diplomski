while ((line = br2.readLine()) != null) { 
    line=line.replaceAll(",,", ",NA,");
    String[] object = line.split(cvsSplitBy);
    rowList.add(object); 
    counterRow++;
}