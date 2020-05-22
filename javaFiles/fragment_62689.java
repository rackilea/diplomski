public void setHeight (int height) {
    if(height > 35 && height < 70){
        System.out.println("Sykkelen er " + height + " cm høy.");
    } else {
        System.out.println("Wrong");
    }
    // add the below line:
    this.height = height;
}