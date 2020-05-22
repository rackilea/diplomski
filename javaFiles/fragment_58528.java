public class FormValidation extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {

        String gender = request.getParameter("gender");
        String age_s = request.getParameter("age");
        String weight_s = request.getParameter("weight");
        String drinks_s = request.getParameter("drinks");
        String hours_s = request.getParameter("hours");
        String gender_s;
        int age_i;
        double weight_d, drinks_d, hours_d;

        if (gender.toLowerCase().equals("male") || 
                gender.toLowerCase().equals("female")) {
            gender_s = gender;
        }
        else {
            gender_s = Person.DEFAULT_GENDER;
        }

        try {
            age_i = Integer.parseInt(age_s);
        }
        catch (NumberFormatException e) {
            age_i = Person.DEFAULT_AGE;
        }
        try {
            weight_d = Double.parseDouble(weight_s);
        }
        catch (NumberFormatException e) {
            weight_d = Person.DEFAULT_WEIGHT;
        }
        try {
            drinks_d = Double.parseDouble(drinks_s);
        }
        catch (NumberFormatException e) {
            drinks_d = Person.DEFAULT_DRINKS;
        }
        try {
            hours_d = Double.parseDouble(hours_s);
        }
        catch (NumberFormatException e) {
            hours_d = Person.DEFAULT_HOURS;
        }

        request.setAttribute("gender", gender_s);
        request.setAttribute("age", age_i);
        request.setAttribute("weight", weight_d);
        request.setAttribute("drinks", drinks_d);
        request.setAttribute("hours", hours_d);
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}