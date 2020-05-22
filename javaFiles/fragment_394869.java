ForkJoinTask<String> fjt=new RecursiveTask<String>() {
    protected String compute() {
        return "hello "+Thread.currentThread();
    }
};
fjt.invoke();
System.out.println(fjt.get());