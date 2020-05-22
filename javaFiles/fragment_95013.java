@RequestMapping(path = "/downloadCSV/{reportId}", method = 
    RequestMethod.GET)
        public void getCSV(@PathVariable String reportId, HttpServletRequest 
         request, HttpServletResponse response) throws Exception {

            byte[] fileContent;

           //write your logic or call service to generate csv report and get 
           bytes of file

                response.setContentType("provide content type");
                ServletOutputStream out = response.getOutputStream();
                out.write(fileContent);
                out.flush();
            return;
        }