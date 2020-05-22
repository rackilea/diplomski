m.setSubject("=?x-mac-ce?Q?Wdro=BFenia_znaku_CE?=");
System.out.printf(
   MimeUtility.decodeText(
       m.getSubject().replace("x-mac-ce","CP1250")
   )
);

>>Wdrożenia znaku CE