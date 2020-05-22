/**Method to Upload File ,called on ValueChangeEvent of inputFile
 * @param vce
 */

public void uploadFileVCE(ValueChangeEvent vce) {
    if (vce.getNewValue() != null) {
        //Get File Object from VC Event
        UploadedFile fileVal = (UploadedFile) vce.getNewValue();
    }
}