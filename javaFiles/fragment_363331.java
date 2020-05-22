class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Singleton singleton1 = Singleton.instance;
        Singleton singleton2 = singleton1.clone();
        System.out.println("singleton1 : "
                       + singleton1.hashCode());
        System.out.println("singleton2 : "
                       + singleton2.hashCode()); 
    }
}