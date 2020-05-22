Thread t1 = new Thread(new Runnable() {
    @Override
    public void run() {
        student = Student.Builder.newInstance().setId(1).setName("Ram").setAddress("Noida").build();
        System.out.println(student.toString());
    }
});

t1.start(); // It starts, but the runnable itself has not run yet!