while (rs.next())
{

    resDCName = rs.getString(1);
 if (resDCName != null && resDCName.equals(oriDCName))
    {
       throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                           "  '" + s + "' is already in use!", null));
     }
   }