String[] command = { "awk",
                     "-F;",
                     "NR>1{gsub(/; +/,\";\",$0);printf(\"{msisdn:\\\"%s\\\",...",
                     "/Users/milena/Desktop/giant.csv"
                   };
Process p = Runtime.getRuntime().exec(command);