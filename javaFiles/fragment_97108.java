Scanner inputLine;
        Scanner inputToken;
        try {
            int counter = 1;
            inputLine = new Scanner(new File("a.txt"));
            while(inputLine.hasNextLine()){
                inputToken=new Scanner(inputLine.nextLine());
                while (inputToken.hasNext())
                {
                    String x = inputToken.next();
                    x = x.replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " ");
                    if (!dictionary.contains(x))
                    {
                        System.out.println("Mispelled word: " + x + ", on line #: " + counter);
                    }
                    if (x.contains("\n"))
                        counter++;
                }
                counter++;
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }