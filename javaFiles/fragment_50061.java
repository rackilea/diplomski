private static void getSubjectHash( X509Certificate x509Cert )
{
    try {
        // get the subject principal
        X500Principal x500Princ = x509Cert.getSubjectX500Principal( );

        // create a new principal using canonical name (order, spacing, etc.) and get it in ANS1 DER format
        byte[] newPrincEnc = new X500Principal( x500Princ.getName( X500Principal.CANONICAL ) ).getEncoded( );

        // read it in as an ASN1 Sequence to avoid custom parsing
        ASN1InputStream aIn = new ASN1InputStream( newPrincEnc );
        ASN1Sequence seq = (ASN1Sequence) aIn.readObject( );

        List<byte[]> terms = new ArrayList<>( );
        int finalLen = 0;
        int i = 0;

        // hash the encodables for each term individually and accumulate them in a list
        for ( ASN1Encodable asn1Set : seq.toArray( ) ) {
            byte[] term = ( (ASN1Set) asn1Set ).getEncoded( );
            term[9] = 0x0c; // change tag from 0x13 (printable string) to 0x0c
            terms.add( term );
            finalLen += term.length;

            // digest the term
            byte[] hashBytes = truncatedHash( getDigest( term ), 4 );
            printByteArray( String.format( "hash of object at %d:", i++ ), hashBytes );

            System.out.println( "" );
        }


        // hash all terms together in order of appearance
        int j = 0;
        byte[] finalEncForw = new byte[finalLen];
        for ( byte[] term : terms )
            for ( byte b : term )
                finalEncForw[j++] = b;

        // digest and truncate
        byte[] hashBytes = truncatedHash( getDigest( finalEncForw ), 4 );

        printByteArray( "hash of all terms in forward order", hashBytes );
        System.out.println( "" );

    }
    catch ( Exception ex ) {
        throw new RuntimeException( "uh-oh" );
    }
}