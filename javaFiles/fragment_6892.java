if (request.getAttribute("dataList") != null) {
    ArrayList basicList = (ArrayList) request.getAttribute("dataList");

    Item myItem = null;
    for (int i=0; i < basicList.size(); i++) {
        myItem = (Item)basicList.get(i)
        System.out.println(myItem.desc + ", size: " + myItem.size);
    }
}