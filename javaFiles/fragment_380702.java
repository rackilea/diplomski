class GrandParent
{
    public GrandParent(String s){
        System.out.println("Calling my grandpa");
    }
}

class Parent extends GrandParent
{
    public Parent(){
        super("");
        System.out.println("Calling my pa");
    }   
}

class Child extends Parent
{
    public Child(){
        //super() implicitly invoked
        System.out.println("Calling my child"); 
    }
}