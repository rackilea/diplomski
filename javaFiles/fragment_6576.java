for(int x = 0; x < width; x++)  
        {
            for(int y = 0; y < height; y++)
            {   
                if((c = br.read()) != -1)
                    map[x][y] = (char) c;
            }                   
        }