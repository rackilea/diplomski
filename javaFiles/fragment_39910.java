drive.files.list({
    q: "mimeType='application/vnd.google-apps.spreadsheet'",
    fields: 'nextPageToken, files(id, name)'
}, (err, response) => {
    //Your code
})