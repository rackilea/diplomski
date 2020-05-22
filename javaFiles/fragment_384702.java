class caller {
        public static void main(String[] args) {
                long initialTime = System.currentTimeMillis();
                precompiled_class_name.main(args);
                long finalTime = System.currentTimeMillis();
                System.out.println("Spent time: " + (finalTime - initialTime));
        }
}