public static int calculatePrizesWon(int[] winnersCount, int roundWinner) {

    int prizesWon = 0;
    if (winnersCount[roundWinner] == 0) {
        JOptionPane.showMessageDialog(null, "Prize won: $106 consolidation prize!");
    } else if (winnersCount[roundWinner] == 1) {
        JOptionPane.showMessageDialog(null, "Prize won: $15,125!");
    } else if (winnersCount[roundWinner] == 2) {
        JOptionPane.showMessageDialog(null, "Prize won: $30,110!");
    } else if (winnersCount[roundWinner] == 3) {
        JOptionPane.showMessageDialog(null, "Prize won: $15,120,000!");
    }
    return prizesWon; // Replace this with the real prize won number.
}