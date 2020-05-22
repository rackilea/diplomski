resK <- jsonlite::fromJSON(as.character(resKi))
resM <- jsonlite::fromJSON(as.character(resMi))

plK <- lapply(resK$results$shapes[[1]]$shell, function(x){
  googleway::encode_pl(lat = x[['lat']], lon = x[['lng']])
})

plM <- lapply(resM$results$shapes[[1]]$shell, function(x){
  googleway::encode_pl(lat = x[['lat']], lon = x[['lng']])
})