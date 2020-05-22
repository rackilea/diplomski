for(i=0; i<n; i++)
    {
        jin.nextLine();  // add this to clear the input from before.
        String name=jin.nextLine();
        int id=jin.nextInt();
        int passport=jin.nextInt();
        int licence=jin.nextInt();

        dudes[i]=new Person(name, id, passport, licence);
    }