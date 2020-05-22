for (i = 0; i < splitLine.length; i++)
        {
            try
            {
                a.add(Integer.valueOf(splitLine[i].trim()));
            }
            catch (NumberFormatException ex)
            {
                System.out.println("Exception Occurs while formating : " + splitLine[i]);
            }
        }