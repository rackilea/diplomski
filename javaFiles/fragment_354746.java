public static void main (String[] args){
    OuterClass outer = new OuterClass();

    // This is the key part: Here you are creating a new instance of inner class 
    // AND defining its body. If you are using Eclipse, and only write the 
    // new InnerClass() part, you'll notice that the IDE complains that you need 
    // to implement the doSomething() method, which you will do as though you
    // were creating a plain 'ol class definition
    outer.showThis(new InnerClass(){ 
        public void doSomething(){
            System.out.println("This is the inner anonymous class speaking!");
        }
    });
}