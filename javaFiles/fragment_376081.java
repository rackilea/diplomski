if (!getArguments().getString("category").equals("Select:")
    //up here, you assume the variable is not null
    && getArguments().getString("category") != null
    //here you check if the variable is null or not, very late...
    && !getArguments().getString("category").isEmpty()
    //here you evaluate if the value of getArguments().getString("category") is not empty
    && !getArguments().getString("category").equals("")
    //here you check one more time if the value of getArguments().getString("category") is not empty) {