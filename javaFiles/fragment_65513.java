private void setupSections() {

        String initial = "\0";
        List<String> sections = new ArrayList<String>();
        mSectionsIndexedByPosition = new int[mFilteredData.size()];
        mPositionsIndexedBySection = new int[mFilteredData.size()];

        int section = 0;
        for (int pos = 0; pos < mFilteredData.size(); pos++) {
            Main country = mFilteredData.get(pos);
            if (initial.charAt(0) != country.getContinent().charAt(0)) {
                initial = country.getContinent().substring(0, 1);
                section = sections.size();
                sections.add(initial);
                mPositionsIndexedBySection[section] = pos;
                mSectionsIndexedByPosition[pos] = section;
            } else {
                mSectionsIndexedByPosition[pos] = section;
            }
        }
        mSections = sections.toArray();
        mPositionsIndexedBySection = Arrays.copyOf(mPositionsIndexedBySection, mSections.length);

    }