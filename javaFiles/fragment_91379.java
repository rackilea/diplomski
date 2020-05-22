POST /v3/users/6/reset_password HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 8afe6ef8-a4cd-fc9d-a6cc-b92766a56bd6

{"old_password":"actualPassword", "new_password":"newOne"}