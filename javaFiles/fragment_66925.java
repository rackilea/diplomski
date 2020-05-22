server {
    listen              443 ssl; # Listen to SSL connections
    ssl_certificate     www.example.com.crt;
    ssl_certificate_key www.example.com.key;
    ssl_protocols       SSLv3 TLSv1 TLSv1.1 TLSv1.2;
    ssl_ciphers         HIGH:!aNULL:!MD5;

    server_name         my-IP.com www.my-IP.com;
    access_log          /var/log/nginx/example.com.access.log main;
    access_log          /var/log/nginx/example.com.cache.log cache;
    error_log           /var/log/nginx/example.com.error.log error;

    location / {
        proxy_pass   http://localhost:80; # Forward requests to your webservice
    }
    Include     /etc/nginx/proxy.conf; # Proxy configuration
}