private static int getTrimmerTypeMapPosition(ArrayList<HashMap<String, String>> mArrType) {
        for (int i = 0; i < mArrType.size(); i++) {
            HashMap<String, String> mp = mArrType.get(i);
            if (mp.get("type").equals("TRIMMER")) {
                return i;
            }    
        }    
        return -1;    
    }