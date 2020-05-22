[Authorize]
public string GetActiveMeter()
{
    string toReturn = string.Empty;
    var userId = User.Identity.GetUserId();
    var currentUser = UserClass.GetUserBranchOfficeId(userId);
    try
    {
        IGenericRepository<Meter> entity = new GenericRepository<Meter>();
        var result = entity
          .GetList(x=>x.State, x => x.MeterType)
          .Where(x=>x.BranchOfficeId==currentUser)
          .Select(x=>new { Id = x.Id, Meter1 = x.Meter1 + ' - " + x.MeterType.Description});

        toReturn = new JavaScriptSerializer().Serialize(result);
    }
    catch (Exception ex)
    {
        throw ex;
    }
    return toReturn;
}