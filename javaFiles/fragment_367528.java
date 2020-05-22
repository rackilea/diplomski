[libdefaults]
default_realm = DOMAIN.COM
default_tkt_enctypes = aes128-cts aes128-cts-hmac-sha1-96 aes256-cts aes256-cts-hmac-sha1-96 rc4-hmac des-cbc-crc des-cbc-md5
default_tgs_enctypes = aes128-cts aes128-cts-hmac-sha1-96 aes256-cts aes256-cts-hmac-sha1-96 rc4-hmac des-cbc-crc des-cbc-md5
permitted_enctypes = aes128-cts aes128-cts-hmac-sha1-96 aes256-cts aes256-cts-hmac-sha1-96 rc4-hmac des-cbc-crc des-cbc-md5
dns_lookup_kdc = true
dns_lookup_realm = false
forwardable = true

[realms]
    DOMAIN.COM = {
        kdc = KDC_HOST.DOMAIN.COM
        admin_server = KDC_HOST.DOMAIN.COM
        default_domain = DOMAIN.COM
    }

[domain_realms]
    domain.com = DOMAIN.COM
    .domain.com = DOMAIN.COM