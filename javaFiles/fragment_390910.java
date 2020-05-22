class cmdquest{
    public foe foes[] = new foe[100];

    public static void main(String args[]) throws Exception{

        //Importing foes.txt to create objects of foes
        java.io.File file = new java.io.File("foes.txt");
        Scanner imp = new Scanner(file);  

        for(int i =0; i<3; i++){
            foes[i]=foe.leDados(imp);
        }
}