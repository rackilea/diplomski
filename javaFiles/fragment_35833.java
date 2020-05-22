for (int t = 1; t < tokens.length; t += 2) {
  result = method(
      result,
      result, tokens[t].charAt(0), 
      Integer.parseInt(tokens[t+1]));
}