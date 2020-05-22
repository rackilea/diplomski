Map<String,Object> session = ActionContext.getContext().getSession();
session.put("mylist",list);
in the second request you can access the object

Map<String,Object> session = ActionContext.getContext().getSession();
List<String> myList=(List)session.get("mylist");


Map<String,Object> session = ActionContext.getContext().getSession();
session.remove("mylist");