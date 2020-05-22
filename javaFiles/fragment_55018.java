// ...
    Friends searchBean = new Friends();

    List<Friends> list = searchBean.loadList(searchText);

        request.setAttribute("recolist", list);

        RequestDispatcher view = request.getRequestDispatcher("My.jsp");
        view.forward(request, response);