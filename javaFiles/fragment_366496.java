if (request != null && request.getContentType() != null) {
    String sittingPlacesStr = request.getParameter("sittingPlaces");
    try {
        int sittingPlaces = Integer.parseInt(sittingPlacesStr);
        String invites = request.getParameter("invitees");
    } catch (NumberFormatException | NullPointerException e) {
        // handle the error here
    }
}