@WebServlet("/autocomplete/*")
public class AutoCompleteServlet extends HttpServlet {
    @Override
    protected void doPost(final HttpServletRequest request,
            final HttpServletResponse response) throws ServletException,
            IOException {

        final List<String> countryList = new ArrayList<String>();
        countryList.add("USA");
        countryList.add("Pakistan");
        countryList.add("Britain");
        countryList.add("India");
        countryList.add("Italy");
        countryList.add("Ireland");
        countryList.add("Bangladesh");
        countryList.add("Brazil");
        countryList.add("United Arab Emirates");
        Collections.sort(countryList);

        // Map real data into JSON

        response.setContentType("application/json");

        final String param = request.getParameter("term");
        final List<AutoCompleteData> result = new ArrayList<AutoCompleteData>();
        for (final String country : countryList) {
            if (country.toLowerCase().startsWith(param.toLowerCase())) {
                result.add(new AutoCompleteData(country, country));
            }
        }
        response.getWriter().write(new Gson().toJson(result));
    }
}