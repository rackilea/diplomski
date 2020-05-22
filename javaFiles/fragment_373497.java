private List<myList> sortLinks(SegmentType s, Set<myList> LinkSet) {
    List<myList> LinkList = new LinkedList<myList>();

    String dep = s.getDep().toString();
    for (int index = 0; !LinkSet.isEmpty(); index++) {

        boolean dependencyFound = false;
        for (Iterator<myList> iterator = LinkSet.iterator(); iterator.hasNext(); ) {
            myList link = iterator.next();
            if (link.getLegDep().toString().equals(dep)) {
                iterator.remove();
                link.setLine(s.getLineCode());
                link.setNb(s.getNb());
                link.setSuff(s.getSuff());
                link.setIndex(index);
                linkList.add(link);

                dep = link.getDest().toString();
                dependencyFound = true;
                break;
            }
        }

        if (!dependencyFound) {
            return Collections.emptyList();
        }
    }
    return linkList;
}