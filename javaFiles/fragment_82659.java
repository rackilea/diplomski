location /item/getImage/ {
    alias /path/to/directory/with/images;
}

location / {
    //proxy to your Tomcat instance
    proxy_pass http://127.0.0.1:8080; 
}