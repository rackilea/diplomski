Map<String, String> formState = new HashMap<String, String>();
formState.put("name", name);
formState.put("birthDate", birthDate);
formState.put("address", address);

filterForm = filterForm.bind(formState, "name", "birthDate", "address");