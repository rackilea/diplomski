for(int i=0;i<names.length;i++) {
        scanner.nextLine();
        System.out.println("Enter name "+ (i+1));
        names[i] =  scanner.nextLine();
        System.out.println("Enter "+ names[i] + "'s Annual income");
        incomes[i] = scanner.nextLong();
}