List<String> TXNOList = new LinkedList<String>();

for (Map<String, Object> map : details) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                logger.info(key+"="+value);
                if(key.equals("TXNO")) {
                    TXNO.add(value);
                }
            }
        }