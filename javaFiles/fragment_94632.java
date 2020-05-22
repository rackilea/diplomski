Map<Integer, List<ConsigneeLoadDetails>> collect =

// group the object by id   
listConsigneeLoadDetails.stream().collect(Collectors.groupingBy(consigneeLoadDetails -> consigneeLoadDetails.tripID));

        List<ConsigneeLoadDetailsDto> dtoList = new ArrayList<>();

        collect.forEach((integer, consigneeLoadDetails) -> {
            List<ConsigneeLoadDetails> list = consigneeLoadDetails;

            if (Optional.ofNullable(list).isPresent() && !list.isEmpty()) {
                ConsigneeLoadDetailsDto dtos = new ConsigneeLoadDetailsDto();
                dtos.setTripID(integer);
                dtos.setConsignor(list.stream().findFirst().get().getConsignor());
                dtos.setVehicleCapacity(list.stream().findFirst().get().getVehicleCapacity());
                dtos.setCLoad(list.stream().findFirst().get().getCLoad());
                dtos.setTruckUtilisation(list.stream().findFirst().get().getTruckUtilisation());
                List<ConsigneeDetails> consigneeDetails = new ArrayList<>();
                list.forEach(next -> {
                    ConsigneeDetails con = new ConsigneeDetails();
                    con.setCap(next.getCap());
                    con.setCity(next.getCity());
                    con.setConsignee(next.getConsignee());
                    con.setDistanceToNext(next.getDistanceToNext());
                    con.setLoad(next.getLoad());
                    consigneeDetails.add(con);
                });
                dtos.setConsigneeDetails(consigneeDetails);
                dtoList.add(dtos);
            }
        });

// Your result will be store in 
// dtoList

    }
}


@Getter
@Setter
@ToString
class ConsigneeLoadDetailsDto {

    private Integer tripID;
    private String consignor;
    private Integer vehicleCapacity;
    private Double cLoad;
    private Integer truckUtilisation;
    private List<ConsigneeDetails> consigneeDetails;
}

@Getter
@Setter
@ToString
class ConsigneeDetails {


    private String consignee;
    private String city;
    private Double distanceToNext;
    private Double load;
    private Integer cap;

}