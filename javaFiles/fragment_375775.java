switch (advPay)
{
    case 'y':
        linkCost = (3 * LINK_FLAT_FEE) - 
                   (3 * LINK_FLAT_FEE) * THREE_MONTH_ADV_DISCOUNT;
        break;
    case 'n':
        linkCost = LINK_FLAT_FEE;
        break;
    default:
        throw new Exception("Invalid value specified: " + advPay);
}