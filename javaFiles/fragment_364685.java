curl -i \
    -H "Authorization: Bearer f56ce778dee04274eba0eab3e9d7b324" \
    -H "Accept: application/json" \
    -H "Content-Type: application/json" \
    -X PUT \
    -d '{"_postuser":{"userid":11,"first_name":"chris","last_name":"paul","password":"cp3"}}' \
    http://ip:port/SampleDSS/user/