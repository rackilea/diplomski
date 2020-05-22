private static String PREFIX = "<job_id>";
private static String SUFFIX = "</job_id>";

public static String extractJobId(Map<String, ?> map) {
    for(String key : map.keySet()) {
        if(key.startsWith(PREFIX) && key.endsWith(SUFFIX))
            return key.substring(PREFIX.length(), key.length()-SUFFIX.length());
    }
    // no job_id found
    return null;
}