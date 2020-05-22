class Close1 implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Closing c1");
    }
}

class Close2 implements AutoCloseable {
    Close1 c1;
    Close2(Close1 c1) {
        this.c1=c1;
    }

    @Override
    public void close() throws Exception {
        System.out.print("Closing c1 from c2: ");
        c1.close();
        System.out.println("Closing c2");
    }
}

void test() {
    System.out.println("Before try block");
    try(Close2 c2=new Close2(new Close1())) {
        System.out.println("In try block");
    }
    catch(Exception ex) {
        System.out.println("Exception: "+ex);
    }
    finally {
        System.out.println("In finally block");
    }
    System.out.println("After try block");
}