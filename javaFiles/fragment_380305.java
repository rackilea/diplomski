splitLine = currentLine.split(" ");
newEntry = new entry();
newEntry.record = Integer.parseInt(splitLine[0]);
newEntry.fName = splitLine[1];
newEntry.lName = splitLine[2];
newEntry.phoneNumber = splitLine[3];
System.out.println(newEntry.record + newEntry.fName + newEntry.lName + newEntry.phoneNumber);
dataList.add(newEntry);