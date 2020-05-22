import com.google.gson.annotations.Expose;

    public ClassA prepareClassA(ClassA detail) {

       Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
       ClassA object_A = gson.fromJson(gson.toJson(detail),ClassA.class);
       return  object_A;

    }