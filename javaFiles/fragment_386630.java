ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();

   //Metodo para agregar Cuentas
public void agregarCuenta(Cuenta c){
    cuentas.add(c);

/*
Cuenta aux[] = new Cuenta[cuentas.length+1];
System.arraycopy(cuentas, 0, aux, 0, cuentas.length);
aux[aux.length-1] = c;
cuentas = aux;
*/

}

public static void mostrarAhorro()
{
    //Si no hay cuentas en el arreglo, nos muestra el siguiente error
    if (cuentas.size() == 0)
    {
        System.out.println("No hay cuentas registradas.");
        return;
    }



    System.out.println("****Lista de cuentas de ahorro****");
    //For  para mostrar todas las cuentas de ahorro
    for (int i = 0; i<cuentas.size();i++) {

        if (cuentas.get(i) instanceof CuentaAhorros)
        {

            System.out.println("Id de cuenta: " + (i+1) +"\n"+ cuentas);
        }


    }

}