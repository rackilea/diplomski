ArrayList<ArrayList<Integer>> vals = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Boolean>> truthtable = new ArrayList<ArrayList<Boolean>>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String mark = "$";
    try {
        while (true) {
            String[] splitline = reader.readLine().split("\\s+");
            ArrayList<Integer> valsrow = new ArrayList<Integer>();
            ArrayList<Boolean> truthrow = new ArrayList<Boolean>();
            for (String element: splitline) 
            {
                if(!element.isEmpty())
                {
                    if (element.startsWith(mark))
                    {
                        truthrow.add(true);
                        element = element.substring(1, element.length());
                    }
                    else 
                        truthrow.add(false);

                    valsrow.add(Integer.parseInt(element.trim()));
                }
            }
            vals.add(valsrow); 
            truthtable.add(truthrow);
        }
    }
    catch(IOException e) {
        System.out.println("prob");
    }