if (sectorCode > 0) {
        if (sectorCode > p.getSectorCode()) {
            return 1;
        }
        else {
            return -1;
        }
    } else if (p.getSectorCode() > 0) {
        return -1;
    } else if (industryCode > 0) {
        if (industryCode > p.getIndustryCode()) {
            return 1;
        }
        else {
            return -1;
        }
    } else if (p.getIndustryCode() > 0) {
        return -1;
    } else {
        return 0; // Should never happen
    }