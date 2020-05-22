58     /** 
59      * The infinite future for the purposes of Apple expiry date 
60      */ 
61     public final static int MAXIMUM_EXPIRY = Integer.MAX_VALUE; 
62 

63     /** 
64      * Constructs an instance of {@code ApnsNotification}. 
65      * 
66      * The message encodes the payload with a {@code UTF-8} encoding. 
67      * 
68      * @param dtoken    The Hex of the device token of the destination phone 
69      * @param payload   The payload message to be sent 
70      */ 
71     public EnhancedApnsNotification( 
72             int identifier, int expiryTime, 
73             String dtoken, String payload) { 
74         this.identifier = identifier; 
75         this.expiry = expiryTime; 
76         this.deviceToken = Utilities.decodeHex(dtoken); 
77         this.payload = Utilities.toUTF8Bytes(payload); 
78     }