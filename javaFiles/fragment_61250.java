StringBuilder sb = new StringBuilder();
      while (v != 0) {
         sb.append(v < 0 ? '1'
               : '0');
         v <<= 1;
      }
      System.out.println(sb.toString());