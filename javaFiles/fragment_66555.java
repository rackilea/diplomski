public static int plusProche (int x, int y, int[] coordonneesHabitations, int ignoreIndex) {
    double distanceA = 0.0; 
    int k = x;
    int z = y;
    int a = 0;
    int b = 0;
    int [] that = Arrays.copyOf(coordonneesHabitations, coordonneesHabitations.length); 
    int taille = that.length;
    int i = 0;
    double minDistance = Float.MAX_VALUE;
    int position = 0;

       for (i = 0; i < taille; i += 2) {

           //here we add the ability to skip the passed index
           if ((i / 2) == ignoreIndex) {
               continue;
           }

           a = that[i];
           b = that[i+1]; 
           distanceA = calculerDistance(a, b, k, z);
           if (distanceA < minDistance) { 
               minDistance = distanceA;
               position = i/2;
               System.out.println(i + " " + minDistance);
           }
       }
       return position;
}