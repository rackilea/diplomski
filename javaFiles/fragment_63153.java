MainCharacter mainCharacter; // Declare it outside
switch (answer) {
        case 1:
            {
                adv.print("you are a mage");
                mainCharacter = new MainCharacterMage(); // Then define it on the inside
                break;
            }
        case 2:
            {
                adv.print("you are an assasin");
                mainCharacter = new MainCharacterAssasin();
                break;
            }
        case 3:
            {
                adv.print("you are a fighter");
                mainCharacter = new MainCharacterFighter();
                break;
            }
        default:
            adv.print("error wrong answer");
            break;
    }