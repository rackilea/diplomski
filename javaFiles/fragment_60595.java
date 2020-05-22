// the custom predicate
public static class RelatedHighlightPredicate implements HighlightPredicate {
    List<Integer> related;

    public RelatedHighlightPredicate(Integer... related) {
        this.related = Arrays.asList(related);

    }
    @Override
    public boolean isHighlighted(Component renderer,
            ComponentAdapter adapter) {
        int modelIndex = adapter.convertRowIndexToModel(adapter.row);
        return related.contains(modelIndex);
    }

}

// its usage
JXTable table = new JXTable(someModel);
table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
final ColorHighlighter hl = new ColorHighlighter(HighlightPredicate.NEVER, 
        table.getSelectionBackground(), table.getSelectionForeground());
table.addHighlighter(hl);
ListSelectionListener l = new ListSelectionListener() {

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) return;
        invokeUpdate((ListSelectionModel) e.getSource());
    }

    private void invokeUpdate(final ListSelectionModel source) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                int singleSelection = source.getMinSelectionIndex();
                if (singleSelection >= 0) {
                    int first = Math.max(0, singleSelection - 2);
                    int last = singleSelection + 2;
                    hl.setHighlightPredicate(new RelatedHighlightPredicate(first, last));
                } else {
                    hl.setHighlightPredicate(HighlightPredicate.NEVER);
                }
            }
        });

    }

};
table.getSelectionModel().addListSelectionListener(l);