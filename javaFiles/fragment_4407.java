public static void main(String[] args) {
    String str = "    {" + 
            "       \"Answers\": [[{" + 
            "           \"Locale\": \"Ru\"," + 
            "           \"Name\": \"Name1\"" + 
            "       }," + 
            "       {" + 
            "           \"Locale\": \"En\"," + 
            "           \"Name\": \"Name2\"" + 
            "       }]," + 
            "       [{" + 
            "           \"Locale\": \"Ru\"," + 
            "           \"Name\": \"Name3\"" + 
            "       }," + 
            "       {" + 
            "           \"Locale\": \"En\"," + 
            "           \"Name\": \"Name4\"" + 
            "       }]]" + 
            "    }";

    Gson gson = new Gson();

    MyObject obj  = gson.fromJson(str, MyObject.class);

    List<List<Part>> answers = obj.getAnswers();

    for(List<Part> parts : answers){
        for(Part part : parts){
            System.out.println("locale: " + part.getLocale() + "; name: " + part.getName());
        }
    }

}