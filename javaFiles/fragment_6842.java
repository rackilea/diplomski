private String attachFileName;

public String getAttachFileName(){
    return attachFileName;
}

public String downloadAttachFile() throws FileNotFoundException {
    attachFileName = ServletActionContext.getRequest().getParameter("myFileFileName");
    fileInputStream = new FileInputStream(new File(AttachFileName));
    return SUCCESS;
}