boolean success = false;
for (DateFormat candidate : formats) {
    try {
        candidate.parse(criteria.getPeriodFrom());
        candidate.parse(criteria.getPeriodTo());
        success = true;
        break;
    }
    catch (ParseException e) {
        // Expected... move on
    }
}
if (!success) {
    errors.reject("Incorrect format");
}