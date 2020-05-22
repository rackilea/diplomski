public class programa1 {

//Instanciar scanner y formato de moneda
private static Scanner sc = new Scanner(System.in);
private static DecimalFormat MONEDA = new DecimalFormat("$#,###.00");
private ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();   

//Arreglo de clases instanciada.
//private static Cuenta[] cuentas = new Cuenta[0];
//private static Movimientos [] movimientos = new Movimientos[0];

public static void main(String[] args) {
//ArrayList cuentas = new ArrayList(); 

ArrayList<Movimientos> movimientos = new ArrayList<Movimientos>();