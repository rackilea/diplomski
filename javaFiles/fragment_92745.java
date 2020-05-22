package com.GDSWebService.tripnomics_GDS_integration.connector.travelport;

import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.GDSWebService.tripnomics_GDS_integration.config.travelport.APIAccessConfig;
import com.GDSWebService.tripnomics_GDS_integration.modal.TravelportCredentials;
import com.GDSWebService.tripnomics_GDS_integration.service.HotelSearchImpl;
import com.GDSWebService.tripnomics_GDS_integration.utils.BindingUtil;
import com.travelport.schema.hotel_v48_0.BaseHotelSearchRsp;
import com.travelport.schema.hotel_v48_0.HotelSearchAvailabilityReq;
import com.travelport.service.hotel_v48_0.HotelSearchServicePortType;
import com.travelport.service.hotel_v48_0.HotelService;

@Component
public class HotelSearchConnector {

    public APIAccessConfig apiAccessConfig;

    public HotelSearchImpl hotelSearchImpl;

    public TravelportCredentials travelportCredentials;

    public HotelSearchServicePortType hotelShop;
    public HotelService hotelShopService;

    @Autowired
    public HotelSearchConnector(APIAccessConfig apiAccessConfig, HotelSearchImpl hotelSearchImpl) {
        this.apiAccessConfig = apiAccessConfig;
        this.hotelSearchImpl = hotelSearchImpl;
        this.travelportCredentials= apiAccessConfig.getAPIAccess();

        this.hotelShopService= new com.travelport.service.hotel_v48_0.HotelService();
        this.hotelShop= hotelShopService.getHotelSearchServicePort();
    }

    public void hotelSearch(HotelSearchAvailabilityReq hsaReq) {

        BaseHotelSearchRsp hsaRsp= new BaseHotelSearchRsp();

        BindingUtil.addParametersToProvider((BindingProvider)hotelShop, travelportCredentials);

        hotelSearchImpl.hotelLowFareSearch(hsaReq, hsaRsp, hotelShop);
    }
}