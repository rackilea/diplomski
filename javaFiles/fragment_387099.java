List localList = new ArrayList();
while (resultSet.next()) {
    localList.add(resultSet.get...);
}
synchronized(list) {
    list.addAll(localList);
}