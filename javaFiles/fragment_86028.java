public class TestingApplication 
    {
        public static void main(String[] args) 
        {
            String[] a = { "Hi", "Hello", "Dear", "Jungle" };
            Map<String, String> map = new HashMap<>();
            map.put("Hi", "1");
            map.put("Hello", "2");
            map.put("Dear", "3");
            map.put("Jungle", "4");
            map.put("Sai", "5");
            map.put("Surya", "6");
            List<String> missedKeyList = new ArrayList<>();
            for (String key : map.keySet()) 
            {
                int c = 0;
                for (int i = 0; i < a.length; i++) 
                {
                    if (key.equals(a[i])) 
                    {
                        c++;
                        System.out.println("App: " + a[i] + " present in DB , So it is passed.");
                        break;
                    }
                }

                if (c == 0) 
                {
                    System.out.println("App: " + key + " not present in DB, So it might have failed");
                    missedKeyList.add(key);
                }
            }

            String[] allKey = Arrays.copyOfRange(a, 0, a.length + missedKeyList.size());
            int counter = a.length;
            for(String missedKey : missedKeyList)
            {
                allKey[counter] = missedKey;
                counter++;
            }
        }
    }