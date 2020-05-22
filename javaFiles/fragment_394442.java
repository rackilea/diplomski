StringBuilder builder = new StringBuilder();
for(char c : englishString.getChars())
{
    builder.append(translationMap.get(c.toString().toUpperCase()));
}

System.out.println(builder.toString());