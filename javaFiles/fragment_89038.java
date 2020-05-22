TextField field_userName= new TextField();

Tooltip tooltip_userName=new Tooltip("Enter user name");

// Set tooltip
field_userName.setTooltip(tooltip_userName);

// Or using Tooltip.install
Tooltip.install(field_userName, tooltip_userName);

// Uninstall tooltip
Tooltip.uninstall(field_userName, tooltip_userName);