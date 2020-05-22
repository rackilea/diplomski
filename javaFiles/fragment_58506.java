1. Retrieve DialogSettings object.
 2. Find your section. If it is null, create it.
 3. Use it to store/load related information.

IDialogSettings settings = WorkbenchPlugin.getDefault().getDialogSettings();
IDialogSettings section = settings.getSection("your_section_name");
if (section == null) {
   section = settings.addNewSection("your_section_name");
} 
String lastSelectedFolder = section.get("your_last_selected_folder_key");