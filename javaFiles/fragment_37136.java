while(result.next())
             {
                    String AccNum = result.getString("AccountNumber");
                    String fNtext = result.getString("FirstName");
                    String mNtext = result.getString("MiddleName");
                    String lNtext = result.getString("LastName");



                    String columnNames[] = { "Account Number ", "First Name", "Last Name","Middle Name" };
                    String dataValues[][]=

                    {
                        {AccNum,fNtext,lNtext,mNtext}

                    };

                    table = new JTable( dataValues, columnNames );

                    scrollPane = new JScrollPane( table );
                    ListAccount.add(scrollPane);

             }