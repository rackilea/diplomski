import org.apache.commons.lang.RandomStringUtils;

public static final int ID_LENGTH = 10;

public String generateUniqueId() {
    return RandomStringUtils.randomAlphanumeric(ID_LENGTH);
}