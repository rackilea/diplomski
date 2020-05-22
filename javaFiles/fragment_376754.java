public class GlobalOptionsFileNameController {

    // ...

    private ReadOnlyStringWrapper filename = new ReadOnlyStringWrapper();

    // ...

    public String getFilename() {
       return filename.get() ;
    }

    public ReadOnlyStringProperty filenameProperty() {
        return filename.getReadOnlyProperty();
    }

    public void setFileName(ActionEvent ev){
        if(rb_local.isSelected()){
            filename.set(txt_filename.getText());
        }else if(rb_server.isSelected()){
            String fileNameServer="//"+txt_serverName.getText()+"/"+txt_path.getText();
            filename.set(fileNameServer);
        }   
    }

    // ...
}