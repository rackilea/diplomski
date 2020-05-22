...
String string = s.toString();
int lastMatch = 0;
while(lastMatch < string.length() && (iFUNCTION = string.indexOf(FUNCTION, lastMatch)) >= 0){
    s.setSpan(new ForegroundColorSpan(Color.CYAN), iFUNCTION, iFUNCTION + FUNCTION.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    lastMatch = iFUNCTION + FUNCTION.length(); // add the length since we've already matched it
}
...