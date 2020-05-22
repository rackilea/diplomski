String value = "StringA:StringB!StringC.StringD";
        char[] charArray = value.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (char out : charArray)
        {
            if (!Character.isLetterOrDigit(out))  // find special characters
            {
                stringBuilder.append(",").append(out).append(","); 
            }
            else
            {
                stringBuilder.append(out);
            }
        }

        String[] resultValue = stringBuilder.toString().split(",");
        System.out.println(Arrays.toString(resultValue));