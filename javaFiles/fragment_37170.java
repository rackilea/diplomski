int totalPrice = 0;
for(VanzatorProduse v : produseVanzatorList)
        {
            int vPrice = Integer.parseInt(v.getPret());
            totalPrice = totalPrice + vPrice;
        }