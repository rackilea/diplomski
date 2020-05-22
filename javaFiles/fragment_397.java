pagesLoop:
        do {
            for (count = 0; count <= 9; count++) {
                data = (String) al1.get(count);  //al1=List of accounts on webelement
                if (stg.equals(data))        //stg=account read from execl
                {
                    utl.checkbox_clicking(data);//calling method to set checkbox if                value matches
                    break pagesLoop;
                }
            }

            utl.Weblement_Click("*name of weblement of next page arrow*");
            al1 = utl.Account_List();   //loading new account list on next page in List
        } while (stg.equals(data));