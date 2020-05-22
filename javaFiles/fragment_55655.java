public class InterfaceInAbstractClassImplementer extends InterfaceInAbstractClass{

    public static void main(String[] args){

        System.out.println("An interface can be implemented ");
        InterfaceInAbstractClassImplementer abc = new InterfaceInAbstractClassImplementer();
        Inter inter = new Inter() {

            @Override
            public void interface_method() {
                // TODO Auto-generated method stub
                System.out.println("An interface can be implemented within a class");
            }
        };
        abc.interface_abstract_class_method(inter);
    }

    public void interface_abstract_class_method(Inter inter) {
        inter.interface_method();
    }
}