private static int[] S_desfaparanteze(int[] poli) {

    int size = poli.length;

    List<Integer> rez = new ArrayList<>();
    List<Integer> rezc = new ArrayList<>();

    // rez.add(1); adauga 1 in coada
    //rez.set(0, 2); pune 2 pe pozitia 0
    //rez.size() dimensiunea
    //rez.get(1) afiseaza elementul pe pozitia 1
    //pentru fiecare paranteza aka element al lui poli
    for (int i = 0; i < size; i++) {
        //pas curent

        //adaug un 0 la sfarsit
        rez.add(0);

        //fac o copie a vectorului rezultat
        rezc = new ArrayList(rez);

        /*System.out.println("rez initial");
         for (int s : rez) {
         System.out.print(s + " ");
         }
         System.out.println();
         System.out.println("rezc initial");
         for (int s : rezc) {
         System.out.print(s + " ");
         }
         System.out.println();*/
        /*System.out.println("primul element: " + rez.get(0));
         System.out.println("primul element in copie: " + rezc.get(0));*/
        //primul element e calculat diferit
        rezc.set(0, rez.get(0) - poli[i]);

        /*System.out.println("rez dupa calcularea primului element");
         for (int s : rez) {
         System.out.print(s + " ");
         }
         System.out.println();
         System.out.println("rezc dupa calcularea primului element");
         for (int s : rezc) {
         System.out.print(s + " ");
         }
         System.out.println();*/
        //calculez si restul elementelor
        for (int j = 1; j < rez.size(); j++) {
            //System.out.println("pe" + j + "pun" + rez.get(j) + "+" + rez.get(j - 1) + "*" + (-poli[i]));
            rezc.set(j, rez.get(j) + rez.get(j - 1) * (-poli[i]));
        }

        //copii vectorul
        rez = rezc;

        /*System.out.println("la sfarsitul fiecarui pas, REZ");
         for (int s : rez) {
         System.out.print(s + " ");
         }
         System.out.println();
         System.out.println("---------------------");*/
    }
    /*System.out.println("la final");

     for (int s : rez) {
     System.out.print(s + " ");
     }*/
    //convertesc arraylist la array simplu
    int[] ret = new int[rez.size() + 1];
    for (int j = 0; j < rez.size(); j++) {
        ret[j + 1] = rez.get(j);
    }
    ret[0] = 1;
    return ret;
}