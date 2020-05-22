public static void main(String[] args) {


    Scanner input = new Scanner(System.in);

    int cases = input.nextInt();        //Número de casos

    int[] dec_nums=new int[cases];      //Arreglo contenedor de casos
    for (int i=0;i<cases;i++){
        dec_nums[i]=input.nextInt();    //Almacenamiento de casos
    }

    String[] bin_nums=new String[cases];  //Arreglo con dec-bin
    for (int i=0;i<cases;i++){              
        bin_nums[i]=(String.format("%032d",(Integer.parseInt(Integer.toBinaryString(dec_nums[i]))))); //Convertir cada decimal en el arreglo a binario
    }


    //Imprimir binarios
    for (int i=0; i<cases;i++){
        System.out.println(bin_nums[i]);
    }

}