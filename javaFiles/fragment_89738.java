function uploadDocument() {
   var selectValue = //get the select value and store it here
   valid = true;

  if(document.fileTextBox.fileLoadName.value == ""){
    alert ("Please attach a file to upload")
    valid = false;
    return;
  } 

  if(selectValue === 'unlimited'){
    loadFileAsTextUNLIMITED()
  } else {
    loadFileAsText()
  }   
}