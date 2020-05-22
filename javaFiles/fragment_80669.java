@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_board_grid,
            container, false);
    GridLayout boardLayout = (GridLayout) rootView.findViewById(
            R.id.gridView);
    boardLayout.setColumnCount(columnsNum);
    boardLayout.setRowCount(rowsNum);
    for (int columnIndex = 0; columnIndex < columnsNum; columnIndex++) {
        for (int rowIndex = 0; rowIndex < rowsNum; rowIndex++) {
            ImageView cellView = (ImageView) inflater.inflate(
                    R.layout.fragment_board_cell, boardLayout, false);
            // Here you can customize it, add listeners, etc.
            boardLayout.addView(cellView);
        }
    }
    return rootView;
}