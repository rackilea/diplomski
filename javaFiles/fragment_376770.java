public class Keys {
    private static final String[] keys = {
        "HGDLV-KLLQC-DM3ON-MAUOX-FNQK5",
        "HQKLD-NYRDL-NJXCV-BVCKF-NRKLC", 
        "LDFCV-BDJCQ-VMFQV-FNRKC-NFCFL"
         //and many more
    };

    public static String getKey(String key) {
        for(String current : keys){
            if(current.equals(key)){
                return "approved";
            }
        }
        return "unapproved";
    }
}