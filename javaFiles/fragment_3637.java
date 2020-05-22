if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
        // Ajax request.
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(String.valueOf(sum));
    } else {
        // Normal request.
        request.setAttribute("sum", sum);
        request.getRequestDispatcher("calculator.jsp").forward(request, response);
    }