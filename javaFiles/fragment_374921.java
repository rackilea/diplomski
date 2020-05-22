return userRepository.findUserByUsername(username)    
       .map(new Func1<User, Object>() {
                @Override
                public Object call(User u) {
                    // ..
                    // apply your logic here
                    // ..
                    return myDataObject; // return you data here to subcribers
                }
            });