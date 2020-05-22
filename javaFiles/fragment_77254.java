int mazesSolved = 0;   
for(int puzzleNum = 1; puzzleNum <= 4; puzzleNum++)
{
    textinput = JOptionPane.showInputDialog("How many puzzles did animal "  + mazeNum + "solve?");
    mazesSolved += Integer.parseInt(textinput);
}