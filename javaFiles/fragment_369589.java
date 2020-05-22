# for a missing webapp which would be named fewbars
RewriteCond %{REQUEST_PATH} ^/fewbars/.*
RewriteRule ^(.*)$ /maintenance/index.html [R,NC]

# for a deployed webapp named fewbars
RewriteCond %{CONTEXT_PATH} /fewbars
RewriteRule ^(.*)$ /maintenance/index.html [R,NC]