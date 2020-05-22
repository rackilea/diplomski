public void updateTransitionProb(Object mapping, int ord, int noteIndex)  {
    int note = notesList.get(noteIndex).getPitch();
    HashMap<Integer, Object> hm = (HashMap<Integer, Object>) mapping;

    if (ord == 0) {
        hm.put(note, (hm.get(note) != null) ? ((Double) hm.get(note)) + 1.0 : new Double(1.0));
    }
    else {
        if (hm.containsKey(note)) {
            this.updateTransitionProb(hm.get(note), --ord, ++noteIndex);
        }
        else {
            hm.put(note, new HashMap<Integer, Object>());
            this.updateTransitionProb(hm.get(note), --ord, ++noteIndex);
        }
    }
}