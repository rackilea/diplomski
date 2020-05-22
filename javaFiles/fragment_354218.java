public void removeDuplicates() {

    for (int i = 0; i < products.size(); i++) {
        for (int j = i + 1; j < products.size(); j++) {
            if (products.get(i).getId().equals(products.get(j).getId())) {
                int totalQty = products.get(i).getQty() + products.get(j).getQty();
                products.get(i).setQty(totalQty);
                products.remove(j);
                j--;


            }


        }

    }

}