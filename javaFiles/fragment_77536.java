GeneratePresignedUrlRequest req = new GeneratePresignedUrlRequest(bucketName, "report/" + name);
ResponseHeaderOverrides overrides = new ResponseHeaderOverrides();
overrides.setContentDisposition("attachment; filename=\"report.html\"");
req.setResponseHeaders(overrides);
URL url = this.client.generatePresignedUrl(req);
System.out.println(url);