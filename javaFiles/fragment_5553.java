// Possible values for n:
// (t\\s*h\\s*e\\s*){1}
// (t\\s*h\\s*e\\s*){2}
// (t\\s*h\\s*e\\s*){3}...
public int consecutiveThe(String s) {
    int n = 0;
    while(true) {
         String expression = "(t\\s*h\\s*e\\s*){" + n + "}";
         Pattern p = Pattern.compile(expression);
         Matcher m = p.matcher(s);
         if(!m.find()) {
            break;
         }
         n++;
    }
    return (n - 1);
}