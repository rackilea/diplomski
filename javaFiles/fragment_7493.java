private static String findGlossaryTerms(String response, List<Glossary> glossary) {
    StringBuilder builder = new StringBuilder();
    for (int offset = 0; offset < response.length(); offset++) {
        boolean match = false;
        for (Glossary item : glossary) {
            // check if the term is present at the current offset
            if (response.startsWith(item.getTerm(), offset)) {
                System.out.println(item.getTerm());
                builder.append("<span class=\"term\">").append(item.getTerm()).append("</span>");
                offset += item.getTerm().length() - 1;
                match = true;
                break;
            }
        }
        if (!match)
            builder.append(response.charAt(offset));
    }
    return builder.toString();
}