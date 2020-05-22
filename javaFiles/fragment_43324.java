private final int totalParams = 2, N = 0, L = 1;

//Params contains value of N[devices] and L[charging bit]
//cn contains power needed by each device
//cs contains power available at outlet
//return value is the number of bits to be flipped. -1 indicates not possible
private int analyseChargeSetUp(int params[], BitSet[] cn, BitSet[] cs) {

        int retVal = -1;

        BitSet ms[] = new BitSet[params[this.N]];

        ArrayList<ArrayList<BitSet>> bxor = new ArrayList<ArrayList<BitSet>>();

        for (int i = 0; i < params[this.N]; i++) {
            BitSet temp = cn[i];

            // System.arraycopy(cs, 0, ms, 0, params[this.N]);

            for (int k = 0; k < params[this.N]; k++)
                ms[k] = (BitSet) cs[k].clone();

            // System.out.println("Size: " + bxor.size());
            bxor.add(i, new ArrayList<BitSet>());

            for (int j = 0; j < params[this.N]; j++) {
                ms[j].xor(temp);
                bxor.get(i).add(j, ms[j]);
            }
        }

        // HashSet<BitSet> evalSet = new HashSet<BitSet>();
        HashMap<BitSet, BitSet> bitMap = new HashMap<BitSet, BitSet>();

        for (ArrayList<BitSet> bl : bxor) {
            for (int j = 0; j < params[this.N]; j++) {
                BitSet temp1 = bl.get(j);
                // if (!evalSet.add(temp1)) {
                if (bitMap.get(temp1) == null) {
                    BitSet temp2 = new BitSet();
                    temp2.set(j);
                    bitMap.put(temp1, temp2);
                } else {
                    bitMap.get(temp1).set(j);
                }
                // }
            }
        }

        BitSet resultGetter = new BitSet(params[this.L]);
        resultGetter.set(0, params[this.L] + 1, true);
        Iterator<BitSet> itr = bitMap.keySet().iterator();
        BitSet temp3 = new BitSet();

        while (itr.hasNext()) {
            temp3 = itr.next();
            if (bitMap.get(temp3).cardinality() == params[this.N]) {
                if (temp3.cardinality() <= resultGetter.cardinality()) {
                    resultGetter = temp3;
                }
            }

        }

        // if (resultGetter.cardinality() == params[this.L])
        // retVal = 0;
        // else if (resultGetter.cardinality() == 0)
        // retVal = -1;
        // else
        if (resultGetter.cardinality() > params[this.L])
            retVal = -1;
        else
            retVal = resultGetter.cardinality();

        return retVal;

    }