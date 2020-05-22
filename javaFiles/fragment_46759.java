for(UserAddress> addr: addressList)
    {
        addr.setIsPrimary(false);

        template.update(addr);
    }