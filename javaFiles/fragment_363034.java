if (RSVPState == 1) {
    RSVPIndicator.setBackgroundResource(R.color.GuestAccepted);
}
else if (RSVPState == 0) {
    RSVPIndicator.setBackgroundResource(R.color.GuestDeclined);
}