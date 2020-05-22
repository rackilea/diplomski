server {
    listen 443;
    ssl on;
    ssl_certificate /etc/ssl/cacert.pem;
    ssl_certificate_key /etc/ssl/privkey.pem;
    server_name opentripplanner.example.com;

    proxy_pass         http://127.0.0.1:8000;
}