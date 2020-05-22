@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {

        HashMap<String, Object> map= new HashMap<>();

        // IMPORTANT
        // here we can try to find resource that has this task
        // and export its info to json like this:


        // CHANGE THIS
        Resource res = new Resource();
        res.firstname = "Toto";
        res.lastname = "Wallace";

        // IMPORTANT END

        map.put("resource", res);

        return map;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Resource value) {
        // IMPORTANT
        // Here you have to create or find appropriate Resource in your code
        // and add current task to it
        System.out.println(name+" "+ value );
    }