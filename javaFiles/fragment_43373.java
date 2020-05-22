protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        Collection parts = req.getParts();
        for (Part part : parts) {
            //... determine if its a file part from content disposition for example
            InputStream is = part.getInputStream();
            //...work with your input stream
        }
    }