while ((nextLine = reader.readNext()) != null)
        {           
            for (i = 0; i <= 305; i++)
            {
                for (x = 0; x <= 3; x++)
                {
                    iaData[i][x] = Integer.parseInt(nextLine[x]);
                }
            }
        }