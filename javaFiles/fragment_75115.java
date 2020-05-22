public static void main(String[] args) {

    Bicycle[] bicycles = new Bicycle[2];
    bicycles[0] = new Bicycle(1, "Haro BMX", true, "Handlebars, Tyres, Frame");
    bicycles[1] = new Bicycle(1, "Orah XMB", true, "Handlebars, Tyres, Frame");

    for (Bicycle bicycle : bicycles){
        System.out.println(bicycle);
    }
}