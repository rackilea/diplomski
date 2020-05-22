while (base10>=1)
    {
        int a = base10 % newBase;
        base10 = base10/newBase;
        switch (a)
        {
            case 0: newNum = "0"+newNum; break;
            case 1: newNum = "1"+newNum; break;
            case 2: newNum = "2" +newNum; break;
            case 3: newNum = "3"+newNum; break;
            case 4: newNum = "4"+newNum; break;
            case 5: newNum = "5"+newNum; break;
            case 6: newNum = "6"+newNum; break;
            case 7: newNum = "7"+newNum; break;
            case 8: newNum = "8"+newNum; break;
            case 9: newNum = "9"+newNum; break;
            case 10: newNum = "A"+newNum; break;
            case 11: newNum = "B"+newNum; break;
            case 12: newNum = "C"+newNum; break;
            case 13: newNum = "D"+newNum; break;
            case 14: newNum = "E"+newNum; break;
            case 15: newNum = "F"+newNum; break;
        }
      }