@RequestMapping(value = "/processUpload", method = RequestMethod.POST)
    public @ResponseBody RateResponse<String> processContractUpload(@RequestParam("txtFile") MultipartFile uploadedFile) throws IOException, InterruptedException{
        String result = "failure";
        String outFile = "C:\\temp\file.txt"
        if(file != null && file.getSize()>0){
            byte[] bytes = file.getBytes();
            BufferedOutputStream stream = null;
            try{
                stream = new BufferedOutputStream(new FileOutputStream(outFile));
                stream.write(bytes);
                result = "success";
            }finally {
                if(stream!=null){
                    stream.close(); 
                }
            }

        }

        return result;
    }