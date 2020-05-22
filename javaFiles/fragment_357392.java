Object obj = new JSONParser().parse(new FileReader("metricDataFinal.json"));
            JSONObject jo = (JSONObject) obj;
            Map ServiceData = ((Map) jo.get("ServiceData"));
            Iterator<Map.Entry> itr1 = ServiceData.entrySet().iterator();
            while (itr1.hasNext()) {
                JSONArray ja = (JSONArray) ServiceData.get("ServiceInfo");
                Iterator itr2 = ja.iterator();
                while (itr2.hasNext()) {
                    itr1 = ((Map) itr2.next()).entrySet().iterator();
                    while (itr1.hasNext()) {
                        Map.Entry pair = itr1.next();
                        System.out.println(pair.getKey() + " : " + pair.getValue());
                    }
                }
                Map.Entry pair = itr1.next();
                // System.out.println(pair.getKey() + " : " + pair.getValue());


            }

        } catch (Exception e) {
            e.printStackTrace();
        }