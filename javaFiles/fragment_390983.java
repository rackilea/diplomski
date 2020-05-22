public void init(String numberOfRowsToPull, String otherProp) {
        // use jdbcTemplate to pull some 
        // set up info from DB
        this.numberOfRowsToPull = numberOfRowsToPull;
        this.otherProp = otherProp;
   }