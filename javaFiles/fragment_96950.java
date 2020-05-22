public class Pepino extends Product{ 
    protected String marca;

    public Pepino(String marca,Double precio){
        this.marca=marca;
        this.precio=precio;
    }

    public void setMarca(String marca){
        this.marca=marca;
    }

    public String getMarca(){
        return marca;
    }   

    public void comprar(){
        System.out.println("Se ha comprado el pepino");
    }
}