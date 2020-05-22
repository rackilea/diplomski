public M(String type) {
    this.type = type.split("\\.");
    String sType = this.type[0]; 
    String mName = this.type[1];
    System.out.println(sType);
}