for (Object seg : LEX.getJSONArray("seg")) {
        JSONArray values = (JSONArray) seg;
        for (Object objValue : values) {
            int value = (int) objValue;
            System.out.print(value + " ");
        }
        System.out.println();
    }