public String dateToSQLFromat(String javaString)
    {

        String day="", month="", year="";

        int dash=0;
        for(int i=0; i<javaString.length(); i++)
        {

            if(javaString.charAt(i)=='-')
            {
                dash++;
                continue;
            }

            if(dash==0)
            {
            year= year+javaString.charAt(i);

            }
            else if(dash==1)
            month= month+javaString.charAt(i);
            else
            {

                if(javaString.charAt(i)==' ')
                    break;

               day= day+javaString.charAt(i);  
            }
        }


        int myMonth= Integer.parseInt(month);

        switch(myMonth)
        {
            case 1: month="JAN"; break;
            case 2: month="FEB";break;
            case 3: month="MAR"; break;
            case 4: month="APR"; break;
            case 5: month= "MAY"; break;
            case 6: month= "JUN"; break;
            case 7: month= "JUL"; break;
            case 8: month="AUG"; break;
            case 9: month="SEP"; break;
            case 10: month="OCT"; break;
            case 11: month="NOV"; break;
            case 12: month="DEC"; break;
            default: System.out.println("Invalid month!"); break;
        }


        return day+"-"+month+"-"+year;



        }