Scanner s1 = new Scanner(new File(file));
            while (s1.hasNextLine())
            {
                ctr = ctr + 1;
                if (s1.hasNext())
                {
                    s1.next();
                }
            }