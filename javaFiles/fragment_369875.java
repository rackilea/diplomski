uploadFile(file:File){
    let form = new FormData();
    form.append("file",file)

    let xhr = new XMLHttpRequest()
    xhr.open("POST",`${URL}/api/upload/avatar`)
    xhr.send(form)
}