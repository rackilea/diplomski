out.println("dn: cn="+column[5]+", ou="+column[7]+", o=Data"+
                    "\nchangetype: " + column[2]
                    + check(column,"\nou: ",7)
                    + check(column,"\nobjectClass: " ,3)
                    + check(column,"\nobjectClass: ",4)
                    + check(column,"\nobjectClass: ",5)
                    + check(column,"\nobjectClass: ",6)
                    + check(column,"\ncn: ",5)
                    + check(column,"\nuid: ",4)
                    + check(column,"\nSAMAccountName: ",1)
                    + check(column,"\ngivenName: ",0)
                    + check(column,"\nsn: ",3)
                    + "\n"
            );