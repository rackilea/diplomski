@RequestMapping(value="/retrievePdf.htm", method=RequestMethod.GET)
    public void retrievePdf(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="uniqueId",required=true)String uniqueId,ModelMap modelMap)throws OSOSystemException
    {
        byte[] db = (byte[]) request.getSession().getAttribute(uniqueId);

        response.getOutputStream().write(db);

        response.setContentType("application/pdf");
        response.setContentLength(db.length);


    }