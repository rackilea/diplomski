public class test { 
        private Object1 o1; 
        private Object2 o2; 
        private Object3 o3; 

        public test() { 
            o1 = new Object1(); 
            o2 = new Object2(); 
            o3 = new Object3();

            o1.setO2(o2);
            o1.setO3(o3);

            o2.setO1(o1);
            o3.setO1(o1);

        } 
    }