try
        {
        username = namefield.getText();
           if (!"admin".equals(username)) {
                throw new Exception("YOUR_MESSAGE_HERE");
            }           
        }
        catch (Exception exe)
        {   
            System.out.println(exe);
            return;
        }