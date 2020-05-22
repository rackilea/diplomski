final class Checker {

  InfoType         it;
  FolderInfoRecord fir;
  FolderInfoData   fid;

  private Checker(FolderInfoData fid, FolderInfoRecord fir) {
    this.it  = fid.getInfoType();
    this.fid = fid;
    this.fir = fir;
  }

  static public boolean isMissing(FolderInfoData fid, FolderInfoRecord fir) {

      return (new Checker(fid, fir)).isMissing();
  }

  private boolean isMissing() {

     return wrongAsNumeric() && wrongAsDate() && wrongAsChoose() && isBlank();
  }

  private boolean wrongAsNumeric() {

    return it.equals(InfoType.NUMERIC) && (fir.getInfoValueNumeric() == null);
  }

  private boolean wrongAsDate() {

    return it.equals(InfoType.DATE) && (fir.getInfoValueNumeric() == null);
  }

  private boolean wrongAsChoose() {

    return it.equals(InfoType.CHOOSE) && folderInfoData.getSelectedInfoRole() == null)
  }

  private boolean isBlank() {

    return StringUtils.isBlank(folderInfoRecord.getInfoValue(), true);
  }  
}