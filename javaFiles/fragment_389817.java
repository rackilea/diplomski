String str = "{\"ProfileInfoResult\":{\"joiningYear\":\"2009\"}}";

    Root root = new Root();

    Gson gson = new Gson();
    root = gson.fromJson(str, Root.class);
    TextView b = new TextView(context);
    b.setText(root.ProfileInfoResult.joiningYear);