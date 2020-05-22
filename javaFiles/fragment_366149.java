public class Tuple<T extends Comparable<T>, V extends T>{
        private IProperty<T> property = null;
        private V value = null;

        public Tuple(IProperty<T> property, V value){
            this.property = property;
            this.value = value;
        }

        public IProperty<T> getProperty() {
            return property;
        }

        public V getValue() {
            return value;
        }
    } 

   <T extends Comparable<T>, V extends T> IBlockState withProperty(Tuple<T, V> t){
        return withProperty( t.getProperty(), t.getValue() );
    }