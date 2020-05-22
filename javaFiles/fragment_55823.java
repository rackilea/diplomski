String newLine = System.getProperty("line.separator");

            Pattern ena = Pattern.compile("S[a-zA-z]{2}ei");
                if(ena.matcher(tretja_beseda).matches()){
                fw.write(prva_beseda + newLine);}
            Pattern dva = Pattern.compile("P[a-zA-z]{3}ei");
                if(dva.matcher(tretja_beseda).matches()){
                    fw.write(prva_beseda + newLine); 
                }