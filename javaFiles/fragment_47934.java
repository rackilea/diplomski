out.println("dn: cn="+column[5]+", ou="+column[7]+", o=Data"+
                    "\nchangetype: " + column[2]
                    + ((column.length > 7 && column[7].length()>0)?"\nou: " + column[7]:"")
                    + ((column.length > 3 && column[3].length()>0)?"\nobjectClass: " + column[3]:"")
                    + ((column.length > 4 && column[4].length()>0)?"\nobjectClass: " + column[4]:"")
                    + ((column.length > 5 && column[5].length()>0)?"\nobjectClass: " + column[5]:"")
                    + ((column.length > 6 && column[6].length()>0)?"\nobjectClass: " + column[6]:"")
                    + ((column.length > 5 && column[5].length()>0)?"\ncn: " + column[5]:"")
                    + ((column.length > 4 && column[4].length()>0)?"\nuid: "+column[4]:"")
                    + ((column.length > 1 && column[1].length()>0)?"\nSAMAccountName: "+column[1]:"")
                    + ((column.length > 0 && column[0].length()>0)?"\ngivenName: "+column[0]:"")
                    + ((column.length > 3 && column[3].length()>0)?"\nsn: "+column[3]:"")
                    + "\n"
            );