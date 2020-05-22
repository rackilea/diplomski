String lineValue = "";

while (inFile1.hasNextLine()) {
  lineValue = inFile1.nextLine();

  if(lineValue.isEmpty()) {
    temps.add(token1);
    token1 = "";
  } else {
    token1 += lineValue;
  }
}