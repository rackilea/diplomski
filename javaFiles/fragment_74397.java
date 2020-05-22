ValueListBox<Users> customListBox = new ValueListBox<Users>(new Renderer<Users>() {
    public String render(Users users) {
        String s = "Select a user";
        if(users != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(users.getUsername());
            sb.append("(");
            sb.append(users.getFirstname());
            sb.append(" ");
            sb.append(users.getLastname());
            sb.append(")").toString();

            s = sb.toString();
        }
        return s;
    }

    public void render(Users users, Appendable appendable) throws IOException {
        String s = render(users);
        appendable.append(s);
  }
});

customListBox.setValue(getUsersList().get(1));
customListBox.setAcceptableValues(getUsersList());