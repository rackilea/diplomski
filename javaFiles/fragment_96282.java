switch(temp.length()) {
    case 6:
        sixLetters.InsertToHead(node);
        break;
    case 5:
        fiveLetters.InsertToHead(node);
        break;
    case 4:
        fourLetters.InsertToHead(node);
        break;
    case 3:
        threeLetters.InsertToHead(node);
        break;
    default:
        rejects.InsertToHead(node);
        break;              
    }