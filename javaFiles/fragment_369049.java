@Override
    protected Void doInBackground(Void... voids) {

        try {

            RestClient client = new RestClient("your url goes here");
            client.AddParam("param1", "value1"));
            client.AddParam("param2", "value2"));
            client.AddHeader("Headername","Value");
            client.Execute(RequestMethod.POST);
            response = client.getResponse();

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }