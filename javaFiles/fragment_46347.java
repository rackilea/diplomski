User user =  getUserById(user_id); //get user's details or create a new User's Object

Country country = getCountryById(country_id); //get Country's object using id or name you're receiving from your HTML-form

user.setCountry(country); //set Country's object in your User's object 

//save user's object