user www-data;
worker_processes auto;
worker_rlimit_nofile 10000;
pid /run/nginx.pid;

events {
    worker_connections 2000;
    multi_accept on;
    use epoll;
}

http {
    open_file_cache max=200000 inactive=20s;
    open_file_cache_valid 30s;
    open_file_cache_min_uses 2;
    open_file_cache_errors on;
    reset_timedout_connection on;
    client_body_timeout 200s; # Use 5s for high-traffic sites
    client_header_timeout 200s;

    ##
    # Basic Settings
    ##
    sendfile on;

    tcp_nopush on;
    tcp_nodelay on;
    keepalive_timeout 900;
    keepalive_requests 10000;
    types_hash_max_size 2048;
    #proxy_buffering off;
    proxy_connect_timeout 1600;
    proxy_send_timeout 1600;
    proxy_read_timeout 1600;
    send_timeout 1600;
    include /etc/nginx/mime.types;
    default_type application/octet-stream;

    access_log /var/log/nginx/stream.access.log;
    error_log /var/log/nginx/stream.error.log;

    gzip on;
    gzip_disable "msie6";

    include /etc/nginx/conf.d/*.conf;
    include /etc/nginx/sites-enabled/*;
}