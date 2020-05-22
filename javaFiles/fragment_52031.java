switch (day % 10) {
    case 1: ordinalBuilder.append("st"); break;
    case 2: ordinalBuilder.append("nd"); break;
    case 3: ordinalBuilder.append("rd"); break;
    default: ordinalBuilder.append("th"); break;
}