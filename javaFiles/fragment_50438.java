^[a-zA-Z]{1,2}\\d{4}[a-zA-Z]{1,2}$|^\\d{4}[a-zA-Z]{3}$

static final private Pattern patternEnrollment = Pattern.compile("^[a-zA-Z]{1,2}\\d{4}[a-zA-Z]{1,2}$|^\\d{4}[a-zA-Z]{3}$");

    public static boolean validateEnrollment(String enrollmentToValidate) {
        return patternEnrollment.matcher(enrollmentToValidate).matches();
    }