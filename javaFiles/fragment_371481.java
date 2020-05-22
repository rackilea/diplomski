List<UserThread> userThreadList = new ArrayList<UserThread>();
for (User user : users) {
    UserThread uT = new UserThread(user);
    uT.start();
    userThreadList.add(uT);
}

for (UserThread uT : userThreadList) {
    try
    {
        uT.join();
    }
    catch (InterruptedException e)
    {
        System.out.println(e.getMessage());
    }
}