function exportIssues() {
  axios.get('/issues/export', { responseType: 'arraybuffer' })
    .then((response) => {
      var blob = new Blob([response.data], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });
      fileSaver.saveAs(blob, 'fixi.xlsx');
    });
}