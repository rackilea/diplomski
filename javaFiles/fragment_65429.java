PolicyDocument = {"expiration": "2010-06-16T11:11:11Z",
 "conditions": [
   ["starts-with", "$key", "" ],
   {"acl": "bucket-owner-read" },
   {"bucket": "travel-maps"},
   {"success_action_redirect": "http://www.example.com/success_notification.html" },
   ["eq", "$Content-Type", "image/jpeg" ],
   ["content-length-range", 0, 1000000]
  ]
}
Policy = Base_64_Encoding_Of(PolicyDocument)
MessageDigest = Sha256_With_RSA(SecretKey, Policy)
Signature = Base64_Encoding_Of(MessageDigest)