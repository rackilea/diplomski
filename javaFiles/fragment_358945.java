public static void main(String[] args) {
Metodos consulta = new Metodos();
int x;
String a=null, b=null;
Scanner n;



while(true){
    while(!a.equals("test"))
    {
        System.out.println("Escriba la unidad de persistencia con la que quiere trabajar/n");
        n = new Scanner(System.in);
        a = n.nextLine ();
        consulta.nombrePersistencia(a);
        System.out.println("The value of a is: " +a);
    }