function nextStep() {
  var allFields = document.getElementsByTagName("input");
  //console.log(allFields);
  for (var index in allFields) {
    console.log('name : '+allFields[index].name); 
    if (allFields[index].type == "text") { // you can change condition by name instead of type
      if (allFields.hasOwnProperty(index)) {
        var attr = allFields[index];
        console.log(attr.value)
      }
    }
  }
}