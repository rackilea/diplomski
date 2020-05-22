String selectSQL = "SELECT * FROM rekopf INNER JOIN repos ON rekopf.rekopfnum=repos.Reposnum WHERE repos.reposart IN (";

            int count = 0;

            for (String anr : anrs){
                selectSQL += "'"+anr+"'";
                count++;
                if (count < anrs.size()){
                    selectSQL += ",";
                }
            }

            selectSQL += ")";