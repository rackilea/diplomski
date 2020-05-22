public static void LeadConduitUSPS(ImageView image){
    System.out.println("Lead Conduit");

    Random rand = new Random();
    int wareSelect = ((int)(rand.nextDouble() * 99)) +1;

    if(wareSelect<=10){ //Calculates the ware the gun has
        System.out.println("Factory New");
    }
    else if(wareSelect>=11 && wareSelect<=25){
        //Changes Image here!!
        image.setImage(new Image("new_image1.png");
    }
    else if(wareSelect>=26 && wareSelect<=60){
        //Changes Image here!!
        image.setImage(new Image("new_image2.png");
    }
    else if(wareSelect>=61 && wareSelect<=80){
        //Changes Image here!!
        image.setImage(new Image("new_image3.png");
    }
    else if(wareSelect>=81){
        //Changes Image here!!
        image.setImage(new Image("new_image4.png");
    }
}