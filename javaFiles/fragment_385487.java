if (aqForm.getId() != null) {
        try {
            Integer.parseInt(aqForm.getId()); // validate by trying to parse
            aqForm.setId(aqForm.getId().trim());
        } catch (NumberFormatException nfe) {
            result.rejectValue("id", "error.id", "Please enter an integer.");
            foundError = true;
        }
    }