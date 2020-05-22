String stringValue = "[InstagramUserSummary(super=dev.niekirk.com.instagram4android.requests.payload.InstagramUserSummary@a4acf205, is_verified=false, profile_pic_id=1773528799482591987_1654599017, is_favorite=false, is_private=false, username = ququletta, pk=1654599017, profile_pic_url=https://instagram.fada1-5.fna.fbcdn.net/vp/8d99014623ed527e52512a20002d884b/5C387E45/t51.2885-19/s150x150/31203725_200759604054857_5778864946146181120_n.jpg, has_anonymous_profile_picture=false, full_name=Ququletta)]";

    // First remove all white spaces
    stringValue = stringValue.replaceAll(" ", "");

    // Find where the username key begins
    int beginIndex = stringValue.indexOf("username");

    // Find where the username value ends
    int endIndex = stringValue.indexOf(",", beginIndex);

    // Subtract the username key and value
    String usernameValue = stringValue.substring(beginIndex, endIndex);

    // Get the username value
    System.out.println(usernameValue.split("=")[1]);