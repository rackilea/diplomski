class Outer<T> {
    private T someValue;

    class Inner {
        T getOuterValue(){
            return someValue;
        }
        void setOuterValue(T value){
            someValue=value;
        }
    }
    //rest of code
}