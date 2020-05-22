contactList.sort(new Comparator<Map<String, Object>>() {
    @Override
    public int compare(Map<String, Object> o1, Map<String, Object> o2) {
        if(null != o1.get("status") && null != o1.get("status")){
            return o2.get("status").toString().compareTo(o1.get("status").toString());
        }else if(null != o1.get("status")){
            return 1;
        }else{
            return -1;
        }
    }
});