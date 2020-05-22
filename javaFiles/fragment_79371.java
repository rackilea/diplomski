public static List<ObjGroup> getNewSampleGroup(int size) {
    List<ObjGroup> sampleGroup = new ArrayList<ObjGroup>();
    sampleGroup.add(new ObjGroup((generateNumbers(size, 1)))); //Positives
    sampleGroup.add(new ObjGroup((generateNumbers(size, -1)))); //Negatives
    return sampleGroup;
}

private static List<Obj> generateNumbers(int size, int x) {
    List<Obj> sampleGroup = new ArrayList<Obj>();
    for (int i = 0; i < size; i ++) {
        Random rand = new Random();
        String randC;
        String randA;
        String randB;
        double randD;

        if (x == 1) {
            randD = rand.nextInt((maxP - minP + 1) + minP);
            randA = "aval";// + String.valueOf(rand.nextInt((max - min + 1) + min));
            randB = "bval";// + String.valueOf(rand.nextInt((max - min + 1) + min));
            randC = "cval";// + String.valueOf(rand.nextInt((max - min + 1) + min));
        } else {
            randD = rand.nextInt((maxP - minP + 1) + minP) * -1;
            randA = "bval";// + String.valueOf(rand.nextInt((max - min + 1) + min));
            randB = "aval";// + String.valueOf(rand.nextInt((max - min + 1) + min));
            randC = "cval";// + String.valueOf(rand.nextInt((max - min + 1) + min));
        }
        sampleGroup.add(new Obj(randA, randB, randC, randD));
    }
    return sampleGroup;
}

public List<ObjGroup> findMatches(List<ObjGroup> unmatchedList) {
    List<Obj> pivotPos = unmatchedList.get(0).getObjs(); //First grouping are positives
    List<Obj> pivotNeg = unmatchedList.get(1).getObjs(); //Second grouping are negatives
    List<ObjGroup> matchedList = new ArrayList<ObjGroup>();
    long iterations = 0;

    Collections.sort(pivotPos);
    Collections.sort(pivotNeg, Collections.reverseOrder());

    for (Iterator<Obj> iteratorPos = pivotPos.iterator(); iteratorPos.hasNext();) {
        final Obj focus = iteratorPos.next();
        iteratorPos.remove(); //Remove this once pulled as you won't match it again.
        for (Iterator<Obj> iteratorNeg = pivotNeg.iterator(); iteratorNeg.hasNext();) {
            final Obj candidate = iteratorNeg.next();
            if (compare(focus, candidate)) {
                matchedList.add(new ObjGroup(new ArrayList<Obj>() {
                    {
                        add(focus);
                        add(candidate);
                    }
                }));
                iteratorNeg.remove(); //Remove this once matched as you won't match it again.
                break;
            }
            iterations ++;
        }
        iterations ++;
    }
    return matchedList;
}