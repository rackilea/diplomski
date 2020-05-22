for (CartItem itm : this.itemList) {
            if (itm.isSameProduct(item)) {
                itm.setQnty(item.getQnty() + itm.getQnty());
                flag = true;
               break;  // It was the same product; break.

            } else {
                this.itemList.add(item);
                flag = true;
                break;  // It wasn't the same product; break.
            }
        }