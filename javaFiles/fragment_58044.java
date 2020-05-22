for(User user1 : list1) {
    for(User user2 : list2) {
        if(user1.getEmpCode().equals(user2.getEmpCode())) {
            if(!user1.getFirstName().equals(user2.getFirstName()) ||
               !user1.getLastName().equals(user2.getLastName()) ||
               !user1.getEmail().equals(user2.getEmail())) {
                resultList.add(user1);
            }
        }
    }
}