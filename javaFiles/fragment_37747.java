switch (WDay) {
        case 2 :
            day = "mon-fri";
            break;
        case 3 :
            day = "mon-fri";
            break;
        case 4 :
            day = "mon-fri";
            break;
        case 5 :
            day = "mon-fri";
            break;
        case 6 :
            day = "mon-fri";
            break;
        case 7 :
            day = "sat";
            break;
        case 1 :
            day = "sun";
            break;
        default :
            throw new RuntimeException("Illegal day: " + WDay);

    }