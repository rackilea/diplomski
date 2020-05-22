/** 
 * This would case the ActionForm object named form to 
 * FileUploadForm which is its sub-class's object
 */
FileUploadForm fileUploadForm = (FileUploadForm) form;

 /** 
  * This uses the getter for  the field `private FormFile file;`
  * in the FileUploadForm class definition to create a FormFile object
  */
 FormFile file = fileUploadForm.getFile ();