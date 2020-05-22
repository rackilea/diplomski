TextField nameField = (TextField)formFields.get(0);

    try
    {
        Category newCategory = new Category(null, nameField.getText(), new Date(), null);

        Set<ConstraintViolation<Category>> errors = validator.validateCategory(newCategory);

        if (errors.isEmpty())
        {
            categoryService.save(newCategory);

            close();
        }
        else
        {
            showErrorMessages(errors);
        }
    }
    catch (Exception ex)
    {
        logger.error("Error adding category : " + ex.getMessage());
    }