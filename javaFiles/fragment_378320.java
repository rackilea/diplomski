downloadFile(fileDetails) {
    let username = getUserName();
    return fetch(`/files/${username}`, {
        method: 'POST',
        body: JSON.stringify(fileDetails)
    }).then(response => {
        return response.blob();
    }).then(response => {
        let blob = new Blob([response], {type: 'application/octet-stream'});
        let fileUrl = window.URL.createObjectURL(blob);
        Files.triggerDownload(fileUrl, fileDetails.fileName);
    }).catch((error) => {
        //myerror
    });
}

static triggerDownload(url, fileName) {
        let a = document.createElement('a');
        a.setAttribute('href', url);
        a.setAttribute('download', fileName);
        a.click();
    }