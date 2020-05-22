class MyGenericClass<T>{
        public static <T>void someGenericAction(T value){
            int key = (Integer)value; // here is your's
            System.out.println(key);
        }

        public static void main(String[] args){
            someGenericAction(12);
        }
}