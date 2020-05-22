public class JsonServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String point = request.getParameter("point");
        System.out.println("Point : " + point );

        if(point != null){

            ObjectMapper mapper = new ObjectMapper();

            try {
                // read from string, convert it to Article class object
                Article user = mapper.readValue(point, Article.class);

                // Conver the Article class object in to the JSON string
                System.out.println("Output Json String is :::::::::::> "+mapper.writeValueAsString(user));


            } catch (Exception e) {  
                e.printStackTrace();     
            } 
        }           
    }
}