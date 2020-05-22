package com.consumer.model; 

@NoArgsConstructor
@AllArgsConstructor
public class CustomModel {   
  @JsonProperty("FILE_LIST")
  @NonNull
  @Getter
  @Setter
  List<InnerModel> filesList;
}