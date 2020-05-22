public void a(){
    try {
        synchronized (this) {
            System.out.println("a");
            return;
        }
    } finally{
        System.out.println("a, finally");
    }
}