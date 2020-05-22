public static String getPriority (String location){
    switch(countSlashes(location)){
        case 3: return "1";
        case 4: return "0.9";
        case 5: return "0.8";
        case 6: return "0.7";
        default: return "0.0"; //or whatever prio in default case
    }
}

//replace everything except '/' to get count of slashes easily
private static int countSlashes(String location) {
    return location.replaceAll("[^/]", "").length();
}