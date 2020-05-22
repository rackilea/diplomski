FileInputStream fStream = new FileInputStream(file);
    BufferedReader input = new BufferedReader(new InputStreamReader(fStream));
    Scanner src = new Scanner(input);
    ArrayList<ArrayList<Integer>> board = new ArrayList<>();

    while(src.hasNextLine())
    {
        String[] line = src.nextLine().split("\\s+");
        board.add(new ArrayList<Integer>());
        for(String num : line)
        {
            if(num.matches("\\d+"))
                board.get(board.size() - 1).add(Integer.parseInt(num));
        }
    }

    for(int i = 0; i < board.size(); i++)
    {
        for(int j = 0; j < board.get(i).size(); j++)
            System.out.print(board.get(i).get(j) + " ");

        System.out.println();
    }