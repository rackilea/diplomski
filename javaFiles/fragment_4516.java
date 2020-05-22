http {
    server {
            listen         80;
            server_name    mydomain.it;
            return         301 https://$server_name$request_uri;
    }

    //other code...
}