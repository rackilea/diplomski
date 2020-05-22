List<String> validProperties = Arrays.asList("mihpayid", "request_id", "bank_ref_num", ...);
String property = verifyPayment[0].trim();
if (validProperties.contains(property)) {
    try {
        PropertyUtils.setProperty(verifyPaymentRO, property, value.trim());
    } catch (Exception e) {
        e.printStackTrace();
    }
}