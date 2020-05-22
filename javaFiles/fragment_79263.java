try {
    double value = 1/0;// to make an exception
    chain.doFilter(request, response);
 } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        request.getRequestDispatcher("/error.html").forward(request, response);
 }