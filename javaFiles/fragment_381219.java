private List<Widget> getWidgetWithMostSources(List<Widget> widgets) {
    List<Widget> filteredWidgets = new ArrayList<Widget>();
    TreeMultimap<Integer, Widget> mapOfWidgetsSortedBySources = TreeMultimap.create(Ordering.natural(), Ordering.allEqual());
    for (Widget next : widgets) {
        mapOfWidgetsSortedBySources.put(next.getSources().intValue(), next);
    }
    //Just return the Widget with the highest source linked to the acoustid
    Collection<Widget> widgetsWithHighestSources = mapOfWidgetsSortedBySources.asMap().lastEntry().getValue();
    filteredWidgets.addAll(widgetsWithHighestSources);
    return filteredWidgets;
}