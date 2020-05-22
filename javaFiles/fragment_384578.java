location / {
            proxy_pass http://localhost:8080/Url/;
        proxy_pass_header Set-Cookie;
        proxy_pass_header X-Forwarded-For;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_cookie_domain localhost test.com;
        proxy_cookie_path /Url/ /;
    }