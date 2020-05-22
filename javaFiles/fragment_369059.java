class ReportController{

   def runReport = {
       File report = createReport() //<-- your method to create a report.
       ReportDirectory.addFile(report);

       redirect(action:"downloadFle" params:[fileName:report.name])

   }    


   def showAllFiles = {
       [files:ReportDirectory.listFiles()]
   }

   def downloadFile = {
      def fileName = params.fileName;

      def fileToDownload = ReportDirectory.findFile(fileName);

      if (fileToDownload){

      response.setContentType("application/octet-stream")
      response.setHeader("Content-disposition", "attachment;filename=${fileToDownload .getName()}")
      response.outputStream << fileToDownload.newInputStream()  //<-- ask the user to download
     }else{
         //handle when the file is not found
     }

   }

   def deleteAllFiles ={
       ReportDirectory.deleteAllFiles()

       [files:ReportDirectory.listFiles()] //<-- return the remaining files, if any.
   }


}