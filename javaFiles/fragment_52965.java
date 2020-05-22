package com.giove.viaggi.hsw.provider.hotelspro;

import java.util.*;
import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name="Envelope")
public class MyBean {

    @XmlPath("SOAP-ENV:Body/ns1:getAvailableHotelResponse/return/availableHotels/item")
    private List<Hotel> hotels;

    public List<Hotel> getHotels(){
        return this.hotels==null?new ArrayList<Hotel>():this.hotels;
    }

}