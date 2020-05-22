public TerminalGui[] getTerminalGuis() {
    Components comps[] = getComponents();
    List<TerminalGui> list = new ArrayList<TerminalGui>();

    if (comps == null) return null;

    for( Component c : comps ) {
        if( c instanceof TerminalGui ) {
            list.add(c);
        }
    }

    return list.toArray(new TerminalGui[list.size()]);
}