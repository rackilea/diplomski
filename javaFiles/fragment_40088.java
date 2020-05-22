Interface A {
        void doX();
}

abstract Class B {
        protected void commonY() {
                // ...
        }
}

Class C extends B implements A{

        public void doX() {
                // ...
        }
}

Class D extends B implements A{

        public void doX() {
                // ...
        }
}