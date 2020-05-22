public static void main(String[] args) {

        String jsonString = "{\"customorId\":\"506\",\"joiningDate\":\"2016-10-26 19:49:17.290671+01\"}";

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSSX") 
                .setPrettyPrinting()
                .create();


        //Deserialize
        Customer customer = gson.fromJson(jsonString, Customer.class);
        System.out.println(customer.toString());

        //Serialize
        Customer customerSerialize = new Customer();
        customerSerialize.setCustomorId("123");
        customerSerialize.setJoiningDate(new Date());

        System.out.println(gson.toJson(customerSerialize));


    }