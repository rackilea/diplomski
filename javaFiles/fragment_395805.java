if(savedInstanceState!=null){
            for(int i = 0; i<savedInstanceState.getInt(savedInstanceExpCount_key); i++){
                ExpsInfo.add(new SailorExperience(savedInstanceState.getString(EXPINFO_KEY + String.valueOf(i))));
            }
            for(int i=0; i<savedInstanceState.getInt(savedInstanceBusyIdsCount_key);i++){
                busyIDs.add(savedInstanceState.getString(BUSYIDS_KEY + String.valueOf(i)));
            }
        }