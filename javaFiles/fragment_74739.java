public void bind(Phonecall call) {
    showCallDetails(call);
    if (expandedAll) {
        expandRL(rlFacilityInformation, arrowexpandcollapseTextView);
    } else if (collapsedAll) {
        collapseRL(rlFacilityInformation, arrowexpandcollapseTextView);
    }
    // ...
}