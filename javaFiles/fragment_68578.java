try {
            Module module = Module.getInstance(value);
            module.initialize(null);
            Slot[] slots = module.getSlotList(true);
            TokenInfo[] infos = new TokenInfo[slots.length];
            for (int i = 0; i < slots.length; i++) {
                infos[i] = slots[i].getToken().getTokenInfo();
            }
            printTokenInfos(infos);
            if (slots.length == 0) {
                System.err.println("No token available!");
                return;
            }
        } catch (TokenException | IOException e1) {
            e1.printStackTrace();
        }

        [...]

    private void printTokenInfos(TokenInfo[] infos) {
        int counter = 0;
        for (TokenInfo info : infos) {
            System.out.println("Token: " + counter++);
            System.out.println(info);
        }
    }

    //"value" passed to Module's getInstance method is th path for .dll module 
    //used for one's type of card.