public List<VehicleRentalContract> list(Long contractID,
            String customerNameOrID, Date date,
            String vehicleDescriptionOrRegistration) {
        Criteria criteria = getSession().createCriteria(
                VehicleRentalContract.class);
        // contractID filter
        if (contractID != null && contractID != 0) {
            criteria.add(Restrictions.eq("id", contractID));
        }
        // customerNameOrID filter
        if (customerNameOrID != null && customerNameOrID.length() > 0) {
            try {
                Long customerID = Long.parseLong(customerNameOrID);
                criteria.add(Restrictions.eq("customer.id", customerID));
            } catch (NumberFormatException e) {
                // assume we have a customer name
                String customerNameQuery = "%" + customerNameOrID.trim() + "%";
                criteria.createAlias("customer", "customer").add(
                        Restrictions.or(Restrictions.like("customer.firstName",
                                customerNameQuery), Restrictions.like(
                                "customer.lastName", customerNameQuery)));
            }
        }
        // date filter
        if (date != null) {
            criteria.add(Restrictions.and(
                    Restrictions.le("rentalPeriod.startDate", date),
                    Restrictions.ge("rentalPeriod.endDate", date)));
        }

        // vehicleDescriptionOrRegistration filter
        if (vehicleDescriptionOrRegistration != null
                && vehicleDescriptionOrRegistration.length() > 0) {
            String registrationQuery = "%"
                    + Vehicle
                            .normalizeRegistration(vehicleDescriptionOrRegistration)
                    + "%";
            String descriptionQuery = "%"
                    + vehicleDescriptionOrRegistration.trim() + "%";

            criteria.createAlias("vehicle", "vehicle").add(
                    Restrictions.or(Restrictions.like("vehicle.registration",
                            registrationQuery), Restrictions.like(
                            "vehicle.description", descriptionQuery)));
        }

        List<VehicleRentalContract> contracts = criteria.list();
        return contracts;
}