switch(i){
        case 1: days = 31; day+= 0; wMonth = "January"; break;
        case 2: if(leap){days = 29;}else{days = 28;};  day += 31; wMonth = "February"; break;
        case 3: days = 31;  if(leap){day += 29;}else{day += 28;}; wMonth = "March"; break;
        case 4: days = 30;  day+= 31; wMonth = "April"; break;
        case 5: days = 31;  day+= 30; wMonth = "May"; break;
        case 6: days = 30;  day+= 31; wMonth = "June"; break;
        case 7: days = 31;  day+= 30; wMonth = "July"; break;
        case 8: days = 31;  day+= 31; wMonth = "August"; break;
        case 9: days = 30;  day+= 31; wMonth = "September"; break;
        case 10: days = 31;  day+= 30; wMonth = "October"; break;
        case 11: days = 30;  day+= 31; wMonth = "November"; break;
        case 12: days = 31;  day+= 30; wMonth = "December"; break;
    }