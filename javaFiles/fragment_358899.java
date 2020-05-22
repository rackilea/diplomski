while (context.nextKey()) {
        String line = context.getCurrentKey().toString();
        HashSet<Text> values = new HashSet<Text>();
        for (Text t : context.getValues()) {
            values.add(new Text(t));
        }

        map.put(line, values);
    }