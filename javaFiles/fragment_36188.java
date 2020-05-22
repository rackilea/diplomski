public readInput() { 

    BufferedReader input = new BufferedReader(new InputStreamReader(
    System.in));

    System.out.println("Enter Var 1:");
    this.var1 = input.readLine();

    System.out.println("Enter Var 2:");
    this.var2 = input.readLine();

    }