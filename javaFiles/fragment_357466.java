// calculate some width to add to pref, f.i. to take the scrollbar width into account
final JScrollPane pane = new JScrollPane(comp);
int prefBarWidth = pane.getVerticalScrollBar().getPreferredSize().width;
// **do not**  
comp.setPreferredSize(new Dimension(comp.getPreferredSize().width + prefBarWidth, ...);
// **do**
String pref = "(pref+" + prefBarWidth + "px)"; 
content.add(pane, "width " + pref);