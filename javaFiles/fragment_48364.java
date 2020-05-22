List<DetailsDTO> list = new ArrayList<DetailsDTO>();    
// and added these DetailsDTO class to an ArrayList   
list.add(detailsDTO);  

List<WholeDetails> wholeDTOList = new ArrayList<WholeDetails>();   
for(DetailsDTO dto:list){  
  WholeDetails whole = new WholeDetails();  
  whole.setUserid(dto.getUserid());  
  whole.setAccountNum(dto.getAccountNum());  
  whole.setStreet(dto.getCustomer().getStreet());  
  whole.setCountry(dto.getCustomer().getCountry());  
  wholeDTOList.add(whole);

}