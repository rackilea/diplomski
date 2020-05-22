@RequestMapping(value = "/updateroomstatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
        public Response<List<SaveResponse>> updateRoomStatus(@RequestBody List<RoomDetail> roomDetails){

   List<SaveResponse> responses = new ArrayList<>();
   for(RoomDetail roomDetail : roomDetails){
        Optional<RoomDetail> getData = roomDetailRepository.findById(roomDetail.getId());
        if(getData.isPresent()) {
            RoomDetail oldData = getData.get();
            //just one data can update
            oldData.setStatus(updatedData.getStatus());
            oldData.setDescription(updatedData.getDescription());

            roomDetailRepository.saveAndFlush(oldData);
            status.setStatusCode("000");
            status.setStatusDesc("Success");
        } else {
            status.setStatusCode("001");
            status.setStatusDesc("Data Not Found");
        }

        log.info("Resp : " + status.toString());
        rvalue.setStatus(status);
        responses.add(rvalue);
     }
return responses;