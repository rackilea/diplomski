if (obj implements Blankable) {

    if (!((Blankable) obj).blankOptionalFields()) {

        logger.debug("Could not blank optional fields for " + obj);
    }
}