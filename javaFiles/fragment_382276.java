public static void printMase(ArrayList<ArrayList<String>> lines)
{
    for (ArrayList<String> row: lines)
    {
        for (String elem: row)
        {
            // Using print so each character is on the same line
            System.out.print(elem);
        }
        // Now use println to end the line
        System.out.println();
    }
}