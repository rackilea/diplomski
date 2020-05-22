for (String str : CE) {
    String[] a = str.split(",");
    CEP.add(a[0].trim());
    if(a.length > 1) {
        CEV.add(a[1].trim());
    } else {
        CEV.add(null); //just check that this is OK
    }
}