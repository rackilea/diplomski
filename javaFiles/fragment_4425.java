boolean typeIs1345 = (alType == 1 || alType == 3 || alType == 4 || alType == 5);

    switch (alSize)
    {
        case 7:
            if (alType == 1 || alType == 3)
                disp = 0.12;
            break;
        case 9:
            disp = typeIs1345 ? 0.27 : 0.21;
            break;
        case 11:
            disp = typeIs1345 ? 0.47 : 0.41;
            break;
        case 12:
            disp = typeIs1345 ? 0.75 : 0.64;
            break;
        case 14:
            disp = typeIs1345 ? 1.1 : 0.96;
            break;
        case 16:
            disp = typeIs1345 ? 1.6 : 1.4;
            break;
        case 18:
            disp = typeIs1345 ? 2.6 : 2.3;
            break;
        case 22:
            disp = typeIs1345 ? 4.0 : 3.6;
            break;
        case 30:
            disp = typeIs1345 ? 9.9 : 9.2;
            break;
    }
}