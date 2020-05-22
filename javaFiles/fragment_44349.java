public static void main(String[] args)
    {
      StringBuilder output = new StringBuilder();
      String inputString = "sequence to analize #{var1} is like #{var2}";
      Pattern pattern = Pattern.compile("#\\{(.*?)\\}");
      Matcher matcher = pattern.matcher(inputString);
      int lastStart = 0;
      while (matcher.find()) {
        String subString = inputString.substring(lastStart,matcher.start());
        String varName = matcher.group(1);
        String replacement = getVarValue (varName);
        output.append(subString).append(replacement);
        lastStart = matcher.end();
      }
      System.out.println(output.toString());
    }

    private static String getVarValue(String varName) {
       return "value"; // do what you got to replace the variable name for its value
    }