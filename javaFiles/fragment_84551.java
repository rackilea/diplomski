HeaderAndBodyTestcase last = null;
for (Iterator<HeaderAndBodyTestcase> iter = list.iterator(); iter.hasNext();) {
    HeaderAndBodyTestcase curr = iter.next();
    if (curr.firstInputFile.equals(curr.secondInputFile)) {
        iter.remove();
    }
    if (last != null) {
        boolean bothEqual = curr.firstInputFile.equals(last.firstInputFile) 
                         && curr.secondInputFile.equals(last.secondInputFile);
        boolean crossedEqual = curr.secondInputFile.equals(last.firstInputFile)
                            && curr.firstInputFile.equals(last.secondInputFile);
        if (bothEqual || crossedEqual) {
            iter.remove();
        }
    }
    last = curr;
}