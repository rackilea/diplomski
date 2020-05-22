Iterator<Map.Entry<Object,String>> iter = objects.entrySet().iterator();
while (iter.hasNext()) {
    Map.Entry<Object,String> entry = iter.next();
    boolean remove = false;
    for(Calendar range: clientTimeRange) {
        if (someCondition) {
            if (remove) {
                iter.remove();
            } else {
                remove = true;
            }
        }
    }
}