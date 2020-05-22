public class DetailRecord extends StringManager {
private final String RECORD_TYPE = "06";
private String userMainReference;
private String secondaryReferenceOfTheUser;
private static final String BILLER_PERIODS = "00";
private String cycle;
private String mainServiceValue;
private static final String BILLED_SERVICE_CODE_BY_ADDITIONAL_COMPANY = "             ";
private static final String ADDITIONAL_SERVICE_VALUE = "              ";
private String expirationDate;
private String collectingBankId;
private String targetAccountNumber;
private String billerAccountType;
private String noBillerId;
private String billerName;
private static final String SOURCE_BANK_CODE = "   ";
private static final String RESERVED = "                        ";
private static final int lengthOfUserMainReference = 48;
private static final int lengthOfTheSecondaryReferenceOfTheUser = 30;
private static final int lengthOfTheCycle = 3;
private static final int lengthOfTheMainServiceValue = 14;
private static final int lengthOfTheCollectingBankId = 8;
private static final int lengthOfTargetAccountNumber = 17;
private static final int lengthOfNoBillerId = 10;
private static final int lengthOfBillerName = 22;


public DetailRecord(String userMainReference, String secondaryReferenceOfTheUser, String cycle, String mainServiceValue, String expirationDate, String collectingBankId, String targetAccountNumber, String billerAccountType, String noBillerId, String billerName) {
    this.userMainReference = userMainReference;
    this.secondaryReferenceOfTheUser = secondaryReferenceOfTheUser;
    this.cycle = cycle;
    this.mainServiceValue = mainServiceValue;
    this.expirationDate = expirationDate;
    this.collectingBankId = collectingBankId;
    this.targetAccountNumber = targetAccountNumber;
    this.billerAccountType = billerAccountType;
    this.noBillerId = noBillerId;
    this.billerName = billerName;
}

public static DetailRecord createWith(String userMainReference, String secondaryReferenceOfTheUser, String cycle, String mainServiceValue, String expirationDate, String collectingBankId, String targetAccountNumber, String billerAccountType, String noBillerId, String billerName) {
    return new DetailRecord(userMainReference, secondaryReferenceOfTheUser, cycle, mainServiceValue, expirationDate, collectingBankId, targetAccountNumber, billerAccountType, noBillerId, billerName);
}

@Override
public String toString() {
    return new StringBuilder()
            .append(RECORD_TYPE)
            .append(fillInWithZerosLeftPad(userMainReference, lengthOfUserMainReference))
            .append(fillInWithBlanksLeftPad(secondaryReferenceOfTheUser, lengthOfTheSecondaryReferenceOfTheUser))
            .append(BILLER_PERIODS)
            .append(fillInWithBlanksLeftPad(cycle, lengthOfTheCycle))
            .append(fillInWithZerosLeftPad(mainServiceValue, lengthOfTheMainServiceValue))
            .append(BILLED_SERVICE_CODE_BY_ADDITIONAL_COMPANY)
            .append(ADDITIONAL_SERVICE_VALUE)
            .append(expirationDate)
            .append(fillInWithZerosLeftPad(collectingBankId, lengthOfTheCollectingBankId))
            .append(fillInWithBlanksLeftPad(targetAccountNumber, lengthOfTargetAccountNumber))
            .append(billerAccountType)
            .append(fillInWithBlanksLeftPad(noBillerId, lengthOfNoBillerId))
            .append(fillInWithBlanksLeftPad(billerName, lengthOfBillerName))
            .append(SOURCE_BANK_CODE)
            .append(RESERVED).toString();
}