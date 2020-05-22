public static void weightArrayLooper() {
    String[] weightToOunce = Project1.setWeightPercentageToOunce();
    for (int i = 0;i < weightArray.length;i++) {
            System.out.println("Lb " + weightArray[i] +  " Oz " + weightToOunce[i]);
        }
}