try {
        String text = "word(\"word1\");\n"
                + "word(\"word2\");\n"
                + "word(\"word3\");\n"
                + "etc";
        Pattern pattern = Pattern.compile("\".*?\"");
        Matcher matcher = pattern.matcher(text);
        ArrayList<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group(0));
        }
        StringBuilder out = new StringBuilder("my_list = {");
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
                out.append(iterator.next());
            if(iterator.hasNext())
                out.append(", ");
        }
        out.append("};");
        JOptionPane.showMessageDialog(null, out.toString());
    } catch (PatternSyntaxException ex) {
        // Syntax error in the regular expression
    }