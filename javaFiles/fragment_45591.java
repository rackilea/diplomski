private int AskPublic() {
        Random r = new Random(); // you should probably make this a class variable
        int A = r.nextInt(101);
        int B = r.nextInt(101 - A);
        int C = r.nextInt(101 - A - B);
        return (100 - A - B - C);
}