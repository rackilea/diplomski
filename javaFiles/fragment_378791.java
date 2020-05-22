function GetFileSize(fileid) {
try {
    var fileSize = 0;
    // for IE
    if(checkIE()) { //we could use this $.browser.msie but since it's deprecated, we'll use this function
        // before making an object of ActiveXObject, 
        // please make sure ActiveX is enabled in your IE browser
        var objFSO = new ActiveXObject("Scripting.FileSystemObject");
        var filePath = $("#" + fileid)[0].value;
        var objFile = objFSO.getFile(filePath);
        var fileSize = objFile.size; //size in b
        fileSize = fileSize / 1048576; //size in mb 
    }
    // for FF, Safari, Opeara and Others
    else {
        fileSize = $("#" + fileid)[0].files[0].size //size in b
        fileSize = fileSize / 1048576; //size in mb 
    }
    alert("Uploaded File Size is" + fileSize + "MB");
}
catch (e) {
    alert("Error is :" + e);
}