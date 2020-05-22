class MyFileDownloadAction extends ActionSupport{

     private String fileName;
     // getter and setter

    public String fileDownload() throws exception{
      // file download logic
      fileName ="abc"  // can set name dynamic from DB
   }

}

<action name="download" class="action.DownloadAction">
        <result name="success" type="stream">
            <param name="contentType">application/octet-stream</param>
            <param name="inputName">fileInputStream</param>
            <param name="contentDisposition">attachment;filename="${filename}"</param>
            <param name="bufferSize">1024</param>
        </result>
        <result name="error">/live/useradminerror.jsp</result>
    </action>