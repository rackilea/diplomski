public void onClick(View aview) {
        if (aview == incidentButton) {
            result = "";
            RSSList.clear();
            startIncidentProgress();
        }
        if (aview == roadButton) {
            result = "";
            RSSList.clear();
            startRoadworksProgress();
        }
        if (aview == plannedButton) {
            result = "";
            RSSList.clear();
            startPlannedProgress();
        }
    }