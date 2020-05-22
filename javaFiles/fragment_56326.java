request.post({
  url: server.baseURL + 'api/data',
  formData: {
    file: {
      value: fileStream,
      options: {
        knownLength: req.headers['content-length']
      }
    }
  }
}, function (err, r, body) {
  // Do rendering stuff, handle callback
})