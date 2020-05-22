public static void addPatients ( String[] n ,int[] a ,char[] t )

 {

    final Scanner scanner = new Scanner(System.in);
    int i=0;
    while (i<n.length )
    {
        System.out.println("Enter Patient’s Name: ");
        n[i] = scanner.nextLine();

        System.out.println("Enter Patient’s Age: ");
        a[i]=scanner.nextInt();

        System.out.println("Enter Patient’s Medical test: ");
        t[i]=scanner.next().charAt(0);
        i++;
        scanner.nextLine(); // To swallow the extra excess newline(enter) character.
    }
    System.out.println("Enter the patient’s index to find his/her information : ");
    final int index= scanner.nextInt();
    System.out.println ("Patient name : " + n[index] +"\n Patient age : " + a[index] +"\n Patient    Medical test: " + t[index]);
}