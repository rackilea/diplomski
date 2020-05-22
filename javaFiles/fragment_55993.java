int compras(){
                    System.out.println("insira o numero de compras que pretende efetuar");
                    do{
                    int compra = sc.nextInt();
                    if(compra == 0)
                            System.out.println("Nenhuma compra efetuada");
                    }
                    while(compra < 0);
                            return compra;
            }