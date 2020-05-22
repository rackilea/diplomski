int dotCount = array.length -1;
char[] newArray = new char[array.length + dotCount];

// copy the characters 
for(int index = 0; index < array.length; index++) {
  newArray[2*index] = array[index];
}

// fill the dots
for(int dotIndex = 0; dotIndex < dotCount; dotIndex++) {
  newArray[2* dotIndex + 1] = '.';
}

return new String(newArray);