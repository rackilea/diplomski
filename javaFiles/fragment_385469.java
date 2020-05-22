...
http {
    ....
    server {
        listen       80;
        server_name  www.yourdomain.com;

        location / {
            access_log off;
            proxy_pass http://127.0.0.1:8080;
            proxy_set_header Host $host;
            proxy_redirect     off;
            proxy_set_header X-Real-IP $remote_addr;
            ...
        }
        ....
    }
}