@SuppressWarnings("resource")
@RequestMapping(value = "get/doc", method=RequestMethod.GET, produces="application/octet-stream")
   public  HttpEntity  getProposalDocs(HttpServletResponse response) throws Throwable{ 
        File doc = new File("C:\\temp\\file.doc");

        InputStream is = new FileInputStream(doc);

        response.setHeader("Content-Disposition", "attachment;filename=\"test.doc\"");
        response.setHeader("Content-Type", "application/octet-stream;");
        StreamUtils.copy(is ,response.getOutputStream());

        return new ResponseEntity(HttpStatus.OK);
    }