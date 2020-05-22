//wrapper class
@JacksonXmlRootElement(localName = "countries")
@Data //lombok
@AllArgsConstructor //lombok
public class Countries {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "country")
    private List<Country> countries;

}

//controller
@RequestMapping(value = "/getAllCountries", method = RequestMethod.GET)
public Object getCountries() throws CustomerNotFoundException{
 return new Countries(countryService.getAllCountries());
}