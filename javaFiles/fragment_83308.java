public enum MyBCStyle {

    /**
     * country code - StringType(SIZE(2))
     */
    C(BCStyle.C),

    /**
     * organization - StringType(SIZE(1..64))
     */
    O(BCStyle.O ),

    /**
     * organizational unit name - StringType(SIZE(1..64))
     */
    OU(BCStyle.OU),

    /**
     * Title
     */
    T(BCStyle.T ),

    /**
     * common name - StringType(SIZE(1..64))
     */
    CN(BCStyle.CN ),

    /**
     * device serial number name - StringType(SIZE(1..64))
     */
    SN(BCStyle.SN ),

    /**
     * street - StringType(SIZE(1..64))
     */
    STREET(BCStyle.STREET ),

    /**
     * device serial number name - StringType(SIZE(1..64))
     */
    SERIALNUMBER(BCStyle.SERIALNUMBER),

    /**
     * locality name - StringType(SIZE(1..64))
     */
    L(BCStyle.L ),

    /**
     * state, or province name - StringType(SIZE(1..64))
     */
    ST(BCStyle.ST ),

    /**
     * Naming attributes of type X520name
     */
    SURNAME(BCStyle.SURNAME ),
    GIVENNAME(BCStyle.GIVENNAME ),
    INITIALS(BCStyle.INITIALS ),
    GENERATION(BCStyle.GENERATION ),
    UNIQUE_IDENTIFIER(BCStyle.UNIQUE_IDENTIFIER ),

    /**
     * businessCategory - DirectoryString(SIZE(1..128)
     */
    BUSINESS_CATEGORY(BCStyle.BUSINESS_CATEGORY ),

    /**
     * postalCode - DirectoryString(SIZE(1..40)
     */
    POSTAL_CODE(BCStyle.POSTAL_CODE ),

    /**
     * dnQualifier - DirectoryString(SIZE(1..64)
     */
    DN_QUALIFIER(BCStyle.DN_QUALIFIER ),

    /**
     * RFC 3039 Pseudonym - DirectoryString(SIZE(1..64)
     */
    PSEUDONYM(BCStyle.PSEUDONYM ),


    /**
     * RFC 3039 DateOfBirth - GeneralizedTime - YYYYMMDD000000Z
     */
    DATE_OF_BIRTH(BCStyle.DATE_OF_BIRTH ),

    /**
     * RFC 3039 PlaceOfBirth - DirectoryString(SIZE(1..128)
     */
    PLACE_OF_BIRTH(BCStyle.PLACE_OF_BIRTH ),

    /**
     * RFC 3039 Gender - PrintableString (SIZE(1)) -- "M", "F", "m" or "f"
     */
    GENDER(BCStyle.GENDER ),

    /**
     * RFC 3039 CountryOfCitizenship - PrintableString (SIZE (2)) -- ISO 3166
     * codes only
     */
    COUNTRY_OF_CITIZENSHIP(BCStyle.COUNTRY_OF_CITIZENSHIP ),

    /**
     * RFC 3039 CountryOfResidence - PrintableString (SIZE (2)) -- ISO 3166
     * codes only
     */
    COUNTRY_OF_RESIDENCE(BCStyle.COUNTRY_OF_RESIDENCE ),


    /**
     * ISIS-MTT NameAtBirth - DirectoryString(SIZE(1..64)
     */
    NAME_AT_BIRTH(BCStyle.NAME_AT_BIRTH ),

    /**
     * RFC 3039 PostalAddress - SEQUENCE SIZE (1..6) OF
     * DirectoryString(SIZE(1..30))
     */
    POSTAL_ADDRESS(BCStyle.POSTAL_ADDRESS ),

    /**
     * RFC 2256 dmdName
     */
    DMD_NAME(BCStyle.DMD_NAME ),

    /**
     * id-at-telephoneNumber
     */
    TELEPHONE_NUMBER(BCStyle.TELEPHONE_NUMBER),

    /**
     * id-at-name
     */
    NAME(BCStyle.NAME),

    /**
     * Email address (RSA PKCS#9 extension) - IA5String.
     * <p>Note: if you're trying to be ultra orthodox, don't use this! It shouldn't be in here.
     */
    EmailAddress(BCStyle.EmailAddress),

    /**
     * more from PKCS#9
     */
    UnstructuredName(BCStyle.UnstructuredName),
    UnstructuredAddress(BCStyle.UnstructuredAddress),
    E(BCStyle.E),
    DC(BCStyle.DC),

    /**
     * LDAP User id.
     */
    UID(BCStyle.UID );

    private ASN1ObjectIdentifier identifier;

    public ASN1ObjectIdentifier getIdentifier() {
        return identifier;
    }

    private MyBCStyle(ASN1ObjectIdentifier asn1ObjectIdentifier) {
        this.identifier = asn1ObjectIdentifier;
    }
}