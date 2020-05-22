switch (WDay) {
        case 1 :
            day = "sun";
            break;
        case 2 : // fall-through
        case 3 : // fall-through
        case 4 : // fall-through
        case 5 : // fall-through
        case 6 :
            day = "mon-fri";
            break;
        case 7 :
            day = "sat";
            break;
        default :
            throw new RuntimeException("Illegal day: " + WDay);
    }