@Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        int i = 0;
        for (SailorExperience se:ExpsInfo) {
            outState.putString(EXPINFO_KEY + String.valueOf(i) ,se.toString());
            i++;
        }
        outState.putInt(savedInstanceExpCount_key, i);

        i = 0;
        for(String s:busyIDs){
            outState.putString(BUSYIDS_KEY + String.valueOf(i),s);
            i++;
        }
        outState.putInt(savedInstanceBusyIdsCount_key, i);
    }