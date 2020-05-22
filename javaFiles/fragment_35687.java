if(user.getPassword().equals(passwordLogin)){
    Intent i = new Intent(LoginUser.this, ProfileUser.class);
    i.putExtra("Username", user.getUsername());
    i.putExtra("firstName", user.getFirstName());
    i.putExtra("lastName", user.getLastName());
    i.putExtra("gre", user.getGre());
    i.putExtra("toefl", user.getToefl());
    startActivity(i);
}