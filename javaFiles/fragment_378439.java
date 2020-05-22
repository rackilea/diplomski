if (data.contains("\r")) {
           System.out.println("CR found");
       }

       sb.append('\"')
           .append(data.replace("\r?\n", ","));
           .append('\"');
           .append('|');