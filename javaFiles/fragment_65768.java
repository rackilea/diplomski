public class exmp3<Object, Object>
{
    private Object abc ;
    private ArrayList<Object> xyz;

        public exmp3(Object abc , ArrayList<Object> xyz)
        {
            this.xyz =  xyz;
        }

        public void put(int i)
        {
            ArrayList<Integer> a =  (ArrayList<Integer>) this.xyz;
            a.add(i);
        }

        public ArrayList<Object> getObject()
        {
            return xyz;
        }
    }