String firstName = "prasoon";
        String lastName = "gupta";
        String createdate = "2 july";
        String emailaddress = "prasoon.gupta@abc.com";
        Customers customers = new Customers();
        customers.setFirstName(firstName);
        customers.setLastName(lastName);
        customers.setCreatedate(createdate);
        customers.setEmailaddress(emailaddress);

        List<Customers> info = scheduleService.getCustomer();
        info.add(customers);