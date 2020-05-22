public static void main(String[] args) throws Exception {

            String time = "September 25,2013";
            HashMap<String,String> hm = new HashMap<String, String>();
            hm.put("January", "Jan");
            hm.put("Febraury", "Feb");
            hm.put("March", "Mar");
            hm.put("April", "Apr");
            hm.put("May", "May");
            hm.put("June", "Jun");
            hm.put("July", "Jul");
            hm.put("August", "Aug");
            hm.put("September", "Sep");
            hm.put("October", "Oct");
            hm.put("November", "Nov");
            hm.put("December", "Dec");
            for (String key : hm.keySet()) {
                if (time.contains(key)) {
                    String newTime = time.replace(key, hm.get(key));
                    System.out.println(newTime);
                }
            }
        }