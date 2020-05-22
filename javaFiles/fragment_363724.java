public interface Generator extends Library {

        public class GoSlice extends Structure {
            public Pointer data;
            public long len;
            public long cap;
            protected List getFieldOrder(){
                return Arrays.asList(new String[]{"data","len","cap"});
            }
        }

        public class GenerateKeysResult extends Structure {
            public GoSlice privateKey;
            public GoSlice publicKey;
            protected List getFieldOrder(){
                return Arrays.asList(new String[]{"privateKey","publicKey"});
            }
        }

        public GenerateKeysResult generateKeys();
}