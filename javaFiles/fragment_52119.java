double totalAmount = 0.0;

...

if(dataArray[0].equals(date)) {
  totalAmount += Double.parseDouble(dataArray[1]) * Double.parseDouble(dataArray[2]);
}

...

return totalAmount;