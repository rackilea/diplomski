public void setFileText(String fileText) {
      String oldValue = this.fileText;
      String newValue = fileText;
      this.fileText = fileText;
      pcSupport.firePropertyChange(FILE_TEXT, oldValue , newValue);

   }

   public void setDelemeter(String str)
   {
       String oldValue = this.str;
      String newValue = str;
      this.str = str;
      pcSupport.firePropertyChange(FILE_DELEMETER, oldValue , newValue);

      System.out.println(str);
   }