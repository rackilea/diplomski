cert = cert-to-validate
   while(not self signed) {
       extract issuer from cert
       scan keychain(s) to find cert with a subject equal to the issuer
       if none found - error
       check if the signature is correct.
       cert = issuers_cert
   }
   if not at the top/root - error