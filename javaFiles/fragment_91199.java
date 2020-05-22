MyPojo{
   List<Entity> myList;
   Object object;
   :
   :
   :
}


@RequestMapping(...)
    public
    @ResponseBody
    MyPojo sendResponse() {
       MyPojo myPojo = new MyPojo ();
       myPojo.setMyList(list);
    return list;
    }