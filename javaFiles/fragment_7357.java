Iterator<Segment> it = segmentList.iterator();
    while (it.hasNext()) {
        Segment seg = it.next();
        if (seg.start <= minEnd && minEnd <= seg.end) {
            it.remove();
        }
    }