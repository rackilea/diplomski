POST /fileupload/upload HTTP/1.1
Host: localhost:8080
Content-Type: multipart/form-data; 
boundary=---------------------------263081694432439
Content-Length: 441
-----------------------------263081694432439
Content-Disposition: form-data; name="file"; filename="sample.txt"
Content-Type: text/plain

Data from sample file
-----------------------------263081694432439
Content-Disposition: form-data; name="destination"

/tmp
-----------------------------263081694432439
Content-Disposition: form-data; name="upload"

Upload
-----------------------------263081694432439--