public string postreq([FromBody] RequestViewModel model)
{
    fddService.mobService service = new mobService();
    if (model.geo == "1")
        return service.NewMessage(Convert.ToInt32(model.region), Convert.ToInt32(model.area),
            Convert.ToInt32(model.sector), model.address, model.mobile, "", model.message, Convert.ToInt32(model.compid), "");
    else
        return service.NewMessage(Convert.ToInt32(model.region), Convert.ToInt32(model.area),
            Convert.ToInt32(model.sector), model.address, model.mobile, "", model.message, Convert.ToInt32(model.compid), model.geo);
}
public class RequestViewModel
{
    public string region { get; set; }
    public string area { get; set; }
    public string sector { get; set; }
    public string address { get; set; }
    public string mobile { get; set; }
    public string username { get; set; }
    public string message { get; set; }
    public string compid { get; set; }
    public string geo { get; set; }
}