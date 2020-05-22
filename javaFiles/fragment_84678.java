for(String s : seats) // remove [] brackets (22,23)
            {

                String[] selected=s.split(","); // remove the comma
                for (String t: selected) 
                {
                    for(int j = 0; j<30;j++)
                    {
                        if(ButtonList[j].getText().equals(t))  // if seats label with 22 and 23
                        {
                            ButtonList[j].setEnabled(false); // non-clickable
                        }
                    }
                }

            }