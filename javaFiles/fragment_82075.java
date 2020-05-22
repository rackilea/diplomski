package blog.weather;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name="xml_api_reply")
@XmlType(propOrder={"location", "currentCondition", "currentTemperature", "forecast"})
@XmlAccessorType(XmlAccessType.FIELD)
public class WeatherReport {

    @XmlPath("weather/forecast_information/city/@data")
    private String location;

    @XmlPath("weather/current_conditions/temp_f/@data")
    private int currentTemperature;

    @XmlPath("weather/current_conditions/condition/@data")
    private String currentCondition;

    @XmlPath("weather/forecast_conditions")
    private List<Forecast> forecast;

}