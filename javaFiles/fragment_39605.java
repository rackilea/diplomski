public String getIssuerCode(String issuerSymbol) {
    String creditCardNumber = null;

    System.out.println(issuerSymbol);

    switch (issuerSymbol) {
        case ISSUER_MASTER_CARD:
            System.out.println("Card was of type: " + ISSUER_MASTER_CARD);
            creditCardNumber = generateMasterCard();
            break;
        case ISSUER_AMER_EXPRESS:
             System.out.println("Card was of type: " + ISSUER_AMER_EXPRESS);
             creditCardNumber = generateAmericanExpress();
             break;
        case ISSUER_VISA:
             System.out.println("Card was of type: " + ISSUER_VISA);
             creditCardNumber = generateVisa();
             break;
        default:
             System.out.println("Card is NOT one of the expected type!");
             break;
        }
    }

    System.out.println("Generated credit card number is : " + creditCardNumber);

    return creditCardNumber;
}