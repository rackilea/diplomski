<%  
// retrieve your list from the request, with casting 
ArrayList<Category> list = (ArrayList<Category>) request.getAttribute("servletName");

// print the information about every category of the list
for(Category category : list) {
    out.println(category.getId());
    out.println(category.getName());
    out.println(category.getMainCategoryId());
}
%>