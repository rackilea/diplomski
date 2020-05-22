String str = "This-Is-a-Test-of-The-Problem";
      StringBuilder sb = new StringBuilder();
      for (String s : str.split("-")) {
         char c = s.charAt(0);
         if (Character.isUpperCase(c)) {
            sb.append(c);
         }
      }
      System.out.println(sb.toString());