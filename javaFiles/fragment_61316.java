public  void manual1(){
    System.out.println("Jogador A");
    System.out.println("Insira as coordenadas do Aircraft Carrier e a sua 
     orientação(0 horizontal, 1 vertical):");
    //linhaAC = scanner.nextInt();
    //colunaAC = scanner.nextInt();

    String op= scanner.next();

    int linhaAC = (int) Character.toUpperCase(op.charAt(0))-'A';
    int colunaAC = (int) op.charAt(1)-'1';
    int orientação = scanner.nextInt();
    System.out.println(linhaAC +"  -  " + colunaAC);


    while((colunaAC >= 4 && orientação == 0) || (linhaAC >= 4 && orientação == 1)){

        System.out.println("Fora do tabuleiro");
        System.out.println("Insira de novo as coordenadas do Aircraft Carrier:  ");
        op= scanner.next();
        linhaAC=(int)Character.toUpperCase(op.charAt(0))-'A';
        colunaAC = (int) op.charAt(1)-'1';
        orientação = scanner.nextInt();
        System.out.println(linhaAC +"  -  " + colunaAC);


    }