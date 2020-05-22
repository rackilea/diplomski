String res = input;
   while (true) {
      String tmp = res.replaceAll("\\{\\{[^}]*\\}\\}", "");
      if (tmp.equals(res)) {
           break;
      }
      res = tmp;
   }