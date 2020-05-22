public int count() {
        int result = 0;
        for(int i = 0; i < query.length(); i++) {
            if(filter.contains(query.charAt(i))){
                result++;
            }
        }
        return result;
    }