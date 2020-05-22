char reponse = 'O';
    name = sc.nextLine();
    while (reponse=='O') {

        System.out.println("Gimme your name! ");
        name = sc.nextLine();
        System.out.println("Hello "+name+"How are you doing ? \n Wanna retry ? (O/N)" );
        reponse = sc.nextLine().charAt(0); ``` 

    }