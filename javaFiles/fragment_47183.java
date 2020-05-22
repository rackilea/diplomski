public class Persona {
   ...
   //You should have instance of RegistroCompra
   RegistroCompra registraCompra = new RegistroCompra();
   public void setDestino() {
        //Option 1: Explicitly call the method
        registraCompra.seleccionarDestino();
        destinoPasajero = registraCompra.obtenerDestino();
    }
}

public class RegistroCompra {

    private String destino;

    public RegistroCompra(){
       //Option 2 : Call the method in constructor
       registraCompra();
    }
    public void seleccionarDestino() {
    ...
    //Set the input to the class level variable destino
    this.destino = input.nextLine();
}
    public String obtenerDestino() {
        return this.destino;
    }

}