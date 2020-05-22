location / {
    proxy_pass http://tomcat:8080/magnet/;
    proxy_cookie_path /magnet /;
    proxy_set_header   X-Real-IP $remote_addr;
    proxy_set_header   X-Forwarded-For $proxy_add_x_forwarded_for;
    proxy_set_header X-Forwarded-Host $server_name;
}