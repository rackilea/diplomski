tmpLE = new ArrayList<Integer>() ;
 strE = matcher.group(1);
 edge = Integer.parseInt(strE);
 tmpLE.add(EI, edge);
 strL = matcher.group(2);
 length = Integer.parseInt(strL);
 tmpLE.add(LI, length);

 singleV.add(j ,tmpLE);
 graph.add(i, singleV);