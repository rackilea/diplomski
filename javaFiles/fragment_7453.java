Map<String,String> hashtable = new Hashtable<>();
hashtable.put("Entire Category","900014");
hashtable.put("Full-Res PDF PDF (print)","724242");
hashtable.put("Composite Pattern","36363636");
hashtable.put("Entire Category","352525");
hashtable.put("Cover Image","95757");
hashtable.put("Cover","7697979");

String s = "Entire Category AND Full-Res PDF PDF (print)";

foreach(Map.Entry<String, String> m : hashtable.entrySet())
    while(s.contains(string.getKey()))
            s= s.replace(string.getKey(), string.getValue());