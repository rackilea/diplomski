String errorMessage = (String)context.getVariable("mysqlTestError");
FormComponent formComponent = formEnvironment.getFormComponentById("ID of label");
formComponent.setVisible(!errorMessage.isEmpty());
((JLabel)formComponent.getConfigurationObject()).setText(errorMessage);

return true;