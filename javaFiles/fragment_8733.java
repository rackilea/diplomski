CommonTokenStream tokens = ...
tokens.fill();
StringBuilder sb = new StringBuilder();
for (Token token : tokens.getTokens()) {
    sb.append(((YourCustomTokenType) token).toString());
}
System.out.print(sb.toString());