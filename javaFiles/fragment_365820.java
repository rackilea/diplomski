public static int[] eStatistics(String[] names) {
    int[] newArray = new int[names.length];

    for (int i = 0; i < names.length; i++) {
        newArray[i] = (int) names[i].chars().filter(ch -> ch == 'e').count();
    }

    return newArray;
}