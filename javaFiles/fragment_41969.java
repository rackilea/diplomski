public String toStringLong() {
    String portalString = " without a portal.";
    if(portal != null)
        portalString = " with a " + portal.portalToStringLong();
    return this.name + ":" +" " + this.description + portalString;
}