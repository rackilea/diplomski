private void sortMoves(final List<Move> moves, final int depth)
{

    int i = 0;
    int j = moves.size() - 1;

    while(i < j) {

        while(equalsKillersPrimary(moves.get(i), depth))
            i++;

        while(!equalsKillersPrimary(moves.get(j), depth))
            j--;

        swap(moves, i, j);
    }
}

private boolean equalsKillersPrimary(Move move, int depth) {

    return killers.primary[depth] != null && move.equals(killers.primary[depth]);
}