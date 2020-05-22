customerList.add(new Customer("jim", true, false));
    customerList.add(new Customer("bob", false, true));
    customerList.add(new Customer("rob", true, true));

    List<Customer> vipCustomers =
            (List<Customer>)new SpelExpressionParser()
                    .parseExpression("#customerList.?[vip]")
                    .getValue(evalContext);
    System.out.println(vipCustomers);
    //[Customer{name='jim'}, Customer{name='rob'}]

    List<Customer> vipANDConfAttendeesCustomers =
            (List<Customer>)new SpelExpressionParser()
                    .parseExpression("#customerList.?[vip and conferenceAttendee]")
                    .getValue(evalContext);
    System.out.println(vipANDConfAttendeesCustomers);
    //[Customer{name='rob'}]        

    List<Customer> vipORConfAttendeesCustomers =
            (List<Customer>)new SpelExpressionParser()
                    .parseExpression("#customerList.?[vip or conferenceAttendee]")
                    .getValue(evalContext);
    System.out.println(vipORConfAttendeesCustomers);
    //[Customer{name='jim'}, Customer{name='bob'}, Customer{name='rob'}]