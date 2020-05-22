public void printarray(List<String[]> usersList)
    {

        for(String[] row: usersList) {
            for(String element:row) {
                System.out.println(element);
            }
        }
        System.out.println();

    }