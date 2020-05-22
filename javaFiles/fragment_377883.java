Integer lastInd = null;
    Integer lastData = null;
    for(int i = 0; i<ind.size(); i++) {
        // New peak value with no removal
        if (i == 0 || ind.get(i) - lastData > mpd) {
            lastInd = i;
            lastData = ind.get(i);
            continue;
        }
        // Remove the lower value, if lower value was lastData switch to
        // make this value the new lastData for comparison
        if (x.get(lastData) >= x.get(ind.get(i))) {
            ind.set(i, -1);
        } else {
            ind.set(lastInd, -1);
            lastInd = i;
            lastData = ind.get(i);
        }
    }
    ind.removeAll(Collections.singleton(-1));