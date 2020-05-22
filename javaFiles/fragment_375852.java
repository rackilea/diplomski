int limit = String.valueOf(maxLimit).length();
int length = String.valueOf(value).length();
StringBuilder displayValue = new StringBuilder();
//add a necessary number of zeros
for(int i=0; i<limit-length; i++) {
     displayValue.append("0");
}
displayValue.append(value);
return displayValue.toString();