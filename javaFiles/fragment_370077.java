public static void filterPers(Person personal[]) {

    System.out.print("The persons contained within the array, are: ");
    for(int i = 0; i < personal.length-1;i++) {
        Person currentPerson = personal[i];
        if (i==personal.length-1)
            System.out.print(currentPerson.name);
        else
            System.out.print(currentPerson.name + ", ");
    }
}