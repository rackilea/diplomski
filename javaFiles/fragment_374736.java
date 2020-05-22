try {
    c.perform();
} catch (BuildException ex) {
    if (this.macroDef.getBackTrace()) {
        throw ProjectHelper.addLocationToBuildException(ex, getLocation());
    }

    ex.setLocation(getLocation());
    throw ex;
}