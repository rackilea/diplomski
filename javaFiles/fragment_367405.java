<VirtualHost *:80>
    ServerName example.com

    DocumentRoot /path_to_crafter/crafter/data/repos/sites/mysite

    RewriteEngine On
    RewriteRule (.*) $1?crafterSite=mysite [QSA,PT]

    ProxyPreserveHost On

    ProxyPass / ajp://localhost:8009/
    ProxyPassReverse / ajp://localhost:8009/

    ErrorLog ${APACHE_LOG_DIR}/mysite-error.log
    CustomLog ${APACHE_LOG_DIR}/mysite-access.log combined
  </VirtualHost>