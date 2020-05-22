events {
  worker_connections 1024;
}

http {

  server {
    listen 80 default_server;
    charset utf-8;
    access_log off;
    try_files $uri $uri/ =404;
    #use google as dns
    resolver 8.8.8.8;
    server_name workaround.xyz;
    return 301 https://$server_name$request_uri;
  }

  server {
        listen 443 ssl;
        charset utf-8;
        access_log off;
        try_files $uri $uri/ =404;
        server_name workaround.xyz;

        ssl_certificate /etc/letsencrypt/live/workaround.xyz-0001/fullchain.pem;
        ssl_certificate_key /etc/letsencrypt/live/workaround.xyz-0001/privkey.pem;

        if ($host = www.$server_name) {
            rewrite ^(.*) https://$server_name$request_uri? permanent;
        }

        location / {
            proxy_pass http://workaround:8085/;
        }

        location ^~ {
            proxy_pass              http://workaround:8085/$request_uri;
            proxy_redirect  off;
            proxy_set_header        X-Real-IP $remote_addr;
            proxy_set_header        X-Forwarded-For $proxy_add_x_forwarded_for;
            proxy_set_header        Host $http_host;
            expires 30d;
         }
    }


}