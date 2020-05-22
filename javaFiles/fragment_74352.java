// in main method
 Animal tobbie = new Cat("siamese", "Tobbie")
 Animal jackie = new Cat("tomcat", "Jackie")

 // in Cat class
 public Cat(String type, String name) {
      super(name)
      this.type = type;
 }