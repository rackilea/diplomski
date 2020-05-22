class MyClass{
        int i;//1
        public void myMethod(){
            i = 10;//referring to 1    
        }

        public void myMethod(int i){//2
            i = 10;//referring to 2
            this.i = 10 //refering to 1    
        }    
    }