public String getStateName() {
    switch (state) {
        case 0: return "turned off";
        case 1: return "stopped";
        case 2: return "accelerating";
        case 3: return "not functional";
        case 4: return "no fuel";
        default: return null;
    }
}