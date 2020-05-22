Map<String, Object> replacements = new HashMap<String, Object>();
        replacements.put("{{token1}}", "texte changé 1");
        replacements.put("{{token2}}", "ici est le texte du token numéro 2");
        replacements.put("{{tokenList1}}", tokenList1);
        replacements.put("{{tokenList2}}", tokenList1);         

        templateWithToken = reportService.findAndReplaceToken(replacements, templateWithToken);