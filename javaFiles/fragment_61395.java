while ((line = bufferedReader.readLine()) != null)
            {
                LinePoliceTooLongException x = new LinePoliceTooLongException(line); 
                try{
                    if (line.length() > 80)
                       throw x;
                }catch(LinePoliceTooLongException le){
                    System.out.println("Line:"+line);
                }
             }