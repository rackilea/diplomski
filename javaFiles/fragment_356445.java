public class ConsumerProducer {
        public String stringPool = null;

        public void put(String s){
            stringPool = s;
        }

        public String get(){
            return stringPool;
        }

        public void clearString(){
            stringPool = null;
        }
}