public boolean showResourceWarning(){

//do somestuff to detect whether a potential ressource warning is shown
...
    if(resourceLeakWarning){
      if(this.checkForExceptions()){
       return false;
      }
    }
 return resourceLeakWarning;
}

private boolean checkForExceptions(){
    if(name.equals("org.apache.commons.io.IOUtils.closeQuietly(Closeable)"){
     return true;
    }
    if(name.equals("com.google.common.io.Closeables.close(Closeable,boolean)")){
     return true;
    }
    if(name.equals("org.apache.commons.io.IOUtils.closeQuietly(Closeable)")){
     return true;
    }
    // code executed for your method:
    return false;
}