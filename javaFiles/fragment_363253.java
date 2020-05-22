for (ElementObject element : elements) {
            for (GiftObject gift : element.gifts) {
                if (gift.nameEn.equals("abcd201957261140057")) {
                    System.out.println(element.id);
                }
            }
        }