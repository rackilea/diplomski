public String connect(FlightDTO flightDTO) { //Added new parameter to recevice flightDTO
        String output = null;

        try {
            UrlBuilder urlBuilder = new UrlBuilder();
            urlBuilder.setOrigin(flightDTO.getOrigin());
            urlBuilder.setDestination(flightDTO.getDestination());
            urlBuilder.setDateFrom(flightDTO.getDateFrom());
            urlBuilder.setDateTo(flightDTO.getDateTo());
            ......//Set other required values
            urlBuilder.ulr();

            System.out.println("URL String : " + urlBuilder.ulr());
            ......//other code    
        }
}