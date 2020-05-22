public static void main(String[] args) 
    {
        try {
            URL url = new URL("http://webpagehere.txt");
            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(url.openStream()));
            String line;
            int i=0;
            Map<String, Integer> map = new TreeMap<String, Integer>();
            while ((line = reader.readLine()) != null) {
                i++;
                System.out.println("Line " + i + "\t" + line);
                // Create a TreeMap to hold words as key and count as value

                String[] words = line.split("[ \n\t\r.,;:!?(){}]");
                for (int j = 0; j < words.length; j++) {
                    String key = words[j].toLowerCase();

                    if (key.length() > 0) {
                        if (!map.containsKey(key)) {
                            map.put(key, 1);
                        }
                        else {
                            int value = map.get(key);
                            value++;
                            map.put(key, value);
                        }
                    }
                }
            }
            reader.close();

            // Get all entries into a set
            Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

            // Get key and value from each entry
            for (Map.Entry<String, Integer> entry: entrySet)
                System.out.println(entry.getKey() + "\t" + entry.getValue());

        } catch (UnknownHostException e) {
            System.out.println("Unknown host. Abort.");
        } catch (NoRouteToHostException e) {
            System.out.println("Cannot reach remote host. Abort.");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

    }