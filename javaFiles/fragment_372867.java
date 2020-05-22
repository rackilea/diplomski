getUserFromNetwork("userId")
            .flatMap(new Function<User, ObservableSource<User>>() {
                @Override
                public ObservableSource<User> apply(User user) throws Exception {
                    if (!user.isVip) {
                        return Observable.just(user);
                    } else {
                        return getVipUserFromNetwork("userId");
                    }
                }
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(user -> {
                if (user.isVip){
                    //display vip user
                }else{
                    //display regular user
                }
            });