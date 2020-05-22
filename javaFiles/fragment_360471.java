char[] result = new char[evenSize];
for (int i = 0; i < string.length(); i++) {
    result[i] = string.charAt(i);
}
for (int i = string.length(); i < evenSize; i++) {
    result[i] = 'x';
}
return new String(result);