private void sortMoves(final List<Move> moves, final int depth)
{
    Collections.sort(moves, new Comparator<Move>() {
        @Override
        public int compare(Move o1, Move o2) {

            if(killers.primary[depth] != null && moves.get(i).equals(killers.primary[depth])) {

                return 0;
            } else {

                return 1;
            }
        }
    });       
}