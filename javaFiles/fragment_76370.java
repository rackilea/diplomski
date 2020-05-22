@(users : List[Users])
@for(user <- users){
    for(post <- user.post) {
        @post.article<br/>
    }
    @user.post</br>
    @user.username</br>
    @user.password</br>
    @user.email</a>
}