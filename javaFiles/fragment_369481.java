final float WEIGHT_GAIN = 0.25f;
String mSize[] = {"tiny", "small", "average", "large"};
class Dog{
        int num_meals, mWeight, dogSize;
        public Dog(int weight){
            num_meals = 0;
            dogSize = 0;
            mWeight = weight;
        }
        public String getSize(){
            return mSize[dogSize];
        }
        void feed(){
            mWeight += mWeight * WEIGHT_GAIN;
            num_meals++;
            dogSize = num_meals/3 < mSize.length-1 ? num_meals/3 : mSize.length - 1; 
        }
}