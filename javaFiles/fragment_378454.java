String mine = "site design / logo © 2014 stack exchange inc; árvíztűrő tükörfúrógép";
mine = Normalizer.normalize(mine, Normalizer.Form.NFD); // Normalize with Canonical decomposition
mine = StringEscapeUtils.escapeHtml3(mine); // Escape the html values now
System.out.println(mine); // Would be - site design / logo &copy; 2014 stack exchange inc; árvíztűrő tükörfúrógép

mine = mine.replaceAll("[^\\p{ASCII}]", "");
mine = StringEscapeUtils.unescapeHtml3(mine); // Unescape
System.out.println(mine); // site design / logo © 2014 stack exchange inc; arvizturo tukorfurogep