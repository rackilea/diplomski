static Comparator<String> compare(){
    return (String a, String b) -> {
        if (a.equals("")) {
            return b.equals("") ? 0 : 1;
        } else if (b.equals("")) {
            return -1;
        } else {
            return a.compareTo(b);
        }
    };
}

static Comparator<String> compareOrderDesc(){
    return (String aStr,String bStr) -> {
        if(aStr.equals("")) return 1;
        else if (bStr.equals("")) return -1;
        String[] a = aStr.split("_");
        String[] b = bStr.split("_");
        if (a[0].equals(b[0]) && a.length >= 2 && b.length >= 2){
            return - Integer.decode(a[1])
                    .compareTo(Integer.decode(b[1]));
        }
        return Integer.decode(a[0])
                .compareTo(Integer.decode(b[0]));
    };
}