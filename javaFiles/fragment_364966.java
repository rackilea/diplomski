public String execute()
    {
        try
        { 
             String filePath=servletRequest.getSession().getServletContext().getRealPath("/"); 
             File fileToCreate= new File(filePath,this.excelDataFileName);
             FileUtils.copyFile(this.excelData, fileToCreate); 
             UploadExcel obj=new UploadExcel();
             obj.readExcel(excelData.getAbsolutePath());  
        }
        catch(Exception e){
            e.printStackTrace();
            addActionError(e.getMessage());
            return INPUT;
        }
        return SUCCESS;
    }