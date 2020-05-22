public void setDetail(boolean active, String description, String title,
                      String username, int price, ParseFile file) {

    setIsActive(active);
    setIsActive(description);
    setPrice(price);
    setListingTitle(title);
    setUsername(username);
    setFile(file);
}

public void setIsActive(boolean a) {
    put("active", a);
}

public void setDescription(String s) {
    put("description", s);
}

public void setPrice(int p) {
    put("price", p);
}

public void setListingTitle(String t) {
    put("title", t);
}

public void setUsername(String u) {
    put("username", u);
}

public void setFile(ParseFile f) {
    put("image", f);
}