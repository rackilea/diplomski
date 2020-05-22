public static String strRepeat(String toRepeat, int reps){
    //Sanity checks go here!
    StringBuilder sb = new StringBuilder();
    for(int x = 0; x < reps; x++){
        sb.append(toRepeat);
    }
    return sb.toString();
}