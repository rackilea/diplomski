// ...
else {
    int i = 0;
    for(; i < users_liked.size(); i++) {
        if(!user.getId().equals(users_liked.get(i).getId())) {
            continue;
        } else {
            // user found! unlike and process etc. etc.
            break;
        }
    }
    if (i == users_liked.size()) {
        // After traversing the array we didn't find the specified user
        // Add user to list and process likes
        users_liked.add(user);
        setLikes(getLikes() + 1);
    }
}
// ... etc. etc.