int index = str1.indexOf('.');
if (index >= 0) {
    answer = str1.substring(0, index+3);
} else {
    answer = str1;
}