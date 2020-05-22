List<Integer> list = new ArrayList<>();
    list.add(0);
    list.add(1);
    list.add(2);
    list.add(3);

    int counter = 0;

    for (int i = 0; i<5; i++){

        counter++;



        if (list.get(i) == list.max()){

            System.out.println(i + "," + list.get(0));
            i=0;
        }

        System.out.println(i + "," + (i+1));

        if (counter==5){
        break;
        }

    }

}