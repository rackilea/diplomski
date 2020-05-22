LiveData<List<String>> getUsersLiveData() {
        LiveData<List<User>> usersLiveData = myRepository.getUserList();
        return Transformations.map(usersLiveData, userList -> {
            return userList.stream().map(user -> user.name).collect(Collectors.toList());
        });
    }