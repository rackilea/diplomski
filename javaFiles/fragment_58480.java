private static final String DEVICE_MODEL_PROPERTY = "ro.product.model"; //$NON-NLS-1$
private static final String DEVICE_MANUFACTURER_PROPERTY = "ro.product.manufacturer"; //$NON-NLS-1$

... ...

private static final char SEPARATOR = '-';

... ...

@Override
public String getName() {
    if (mName == null) {
        mName = constructName();
    }

    return mName;
}

private String constructName() {
    if (isEmulator()) {
        String avdName = getAvdName();
        if (avdName != null) {
            return String.format("%s [%s]", avdName, getSerialNumber());
        } else {
            return getSerialNumber();
        }
    } else {
        String manufacturer = cleanupStringForDisplay(
                getProperty(DEVICE_MANUFACTURER_PROPERTY));
        String model = cleanupStringForDisplay(
                getProperty(DEVICE_MODEL_PROPERTY));

        StringBuilder sb = new StringBuilder(20);

        if (manufacturer != null) {
            sb.append(manufacturer);
            sb.append(SEPARATOR);
        }

        if (model != null) {
            sb.append(model);
            sb.append(SEPARATOR);
        }

        sb.append(getSerialNumber());
        return sb.toString();
    }
}

private String cleanupStringForDisplay(String s) {
    if (s == null) {
        return null;
    }

    StringBuilder sb = new StringBuilder(s.length());
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if (Character.isLetterOrDigit(c)) {
            sb.append(Character.toLowerCase(c));
        } else {
            sb.append('_');
        }
    }

    return sb.toString();
}