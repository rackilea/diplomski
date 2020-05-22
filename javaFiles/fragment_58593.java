public void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        // update customer
        int customerId = 0;
        try {
            customerId = 
                    Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
           response.getWriter().write("Error: Customer ID could not be parsed to a number");
           return; //to exit the function: we don't want to do anything more if we encounter this error
        }
        Customer customer = getCustomer(customerId);
        if (customer != null) {
            customer.setFirstName(request.getParameter("firstName"));
            customer.setLastName(request.getParameter("lastName"));
            customer.setEmail(request.getParameter("email"));
            customer.setPhone(request.getParameter("phone"));
            customer.setAddress(request.getParameter("address"));
            customer.setCity(request.getParameter("city"));
            customer.setZip(request.getParameter("zip"));
            makeCustomerReceipt(request, response);
            return; //to exit the function: you should always do this after forward or redirect
        }
        else
        {
           response.getWriter().write("Error: customer is null");
           return; //to exit the function
        }
    }
}