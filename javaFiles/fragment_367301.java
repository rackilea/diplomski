class One {
    public Two two(String s) {
        return new MyTwo();
    }

    class MyTwo extends Two {
        public int display() {
            System.out.println("display()");
            return 1;
        }
    }
}