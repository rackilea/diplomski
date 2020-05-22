public static void checkOuts(String[] names, double[] price, int[] packs, int[] buyItems) {

        System.out.println("Name\tnumFree\ttotalNum\tTotalPrice");
        for (int i = 0; i < names.length; i++) {
            int numFree = buyItems[i] / (packs[i] + 1);
            double totalPrice = (buyItems[i] - numFree) * price[i];
            System.out.println(names[i] + "\t" + numFree + "\t" + buyItems[i] + "\t\t" + totalPrice);
        }

    }