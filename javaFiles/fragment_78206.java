[domain_realm]  
    .testdomain.ourcompany.co.uk = TESTDOMAIN.OURCOMPANY.CO.UK
    testdomain.ourcompany.co.uk = TESTDOMAIN.OURCOMPANY.CO.UK

[libdefaults]   
    default_realm = TESTDOMAIN.OURCOMPANY.CO.UK
    permitted_enctypes = aes128-cts aes256-cts arcfour-hmac-md5 
    default_tgs_enctypes = aes128-cts aes256-cts arcfour-hmac-md5 
    default_tkt_enctypes = aes128-cts aes256-cts arcfour-hmac-md5 

[realms]    
VERDAD.LOCAL = {        
    kdc = test-dc.ourcompany.co.uk  
    admin_server = test-dc.ourcompany.co.uk
    default_domain = TESTDOMAIN.OURCOMPANY.CO.UK
}