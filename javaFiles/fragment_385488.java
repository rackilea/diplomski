String id = aqForm.getId();
   if (id != null) {
      if (isValidInteger(id)) {
         aqForm.setId(id.trim());
      } else {
         result.rejectValue("id", "error.id", "Please enter an integer.");
         foundError = true;
      }
   }