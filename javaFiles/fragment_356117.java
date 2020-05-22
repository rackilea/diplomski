Iterator<Map.Entry<String, Integer>> iterator = 
    group0.entrySet().iterator();
while (iterator.hasNext()) {
    Map.Entry<String, Integer> entry = iterator.next();

    // determine where to assign 'entry'
    iEntryGroup = hasBeenAccusedByGroup(entry.getKey());

    if (iEntryGroup == 1) {
        assign(entry.getKey(), entry.getValue(), 2);
    } else {
        assign(entry.getKey(), entry.getValue(), 1);
    }

    // I don't know under which conditions you want to remove the entry
    // but here's how you do it
    iterator.remove();
}