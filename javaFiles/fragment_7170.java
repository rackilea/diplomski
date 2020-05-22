onUpload(event) {
    let fileReader = new FileReader();
    for (let file of event.files) {
      fileReader.readAsDataURL(file);
      fileReader.onload = function () {
          // Will print the base64 here.
          console.log(reader.result);
      };
    }
  }