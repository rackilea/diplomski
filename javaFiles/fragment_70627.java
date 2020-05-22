server {

listen 80;
server_name _;
location / {

        proxy_pass http://127.0.0.1:8090;
        proxy_redirect off;
        proxy_pass_request_headers on;

        proxy_set_header Host $http_host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;

        proxy_http_version 1.1;
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection Upgrade;

    }