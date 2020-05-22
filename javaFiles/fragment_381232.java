private Iterator<Integer> availableVms = null;
@Override
public int getNextAvailableVm() {
    if (availableVms != null) {
        if (availableVms.hasNext()) {
            return availableVms.next();
        }
        return 0;
    }
    List<Integer> tmp = new ArrayList<Integer>();
    Set<String> dataCenters = confMap.keySet();
    for (String dataCenter : dataCenters) {
        LinkedList<DepConfAttr> list = confMap.get(dataCenter);
        Collections.sort(list, new MemoryComparator());
        int size = list.size() - 1;
        int count = 0;
        while(size >= 0) {
            DepConfAttr dca = (DepConfAttr)list.get(count);
            int currVm = dca.getVmCount();
            int c = 0;
            while(c <= currVm) {
                allocatedVm(currVm);
                c++;
                tmp.add(currVm);
            }
            count++;
            size--;
        }
    }
    availableVms = tmp.iterator();
    return availableVms.hasNext() ? availableVms.next() : 0;
}