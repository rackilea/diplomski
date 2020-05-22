Kdata <- resK$results$shapes[[1]]$shell
Mdata <- resM$results$shapes[[1]]$shell

xyfunc <- function(mydf) {
  xy <- mydf[,c(2,1)]
  return(xy)
}

spdf <- function(xy, mydf){
            sp::SpatialPointsDataFrame(
                coords = xy, data = mydf,
                proj4string = CRS("+proj=longlat +datum=WGS84 +ellps=WGS84 +towgs84=0,0,0"))}

for (i in (1:length(Kdata))) {Kdata[[i]] <- xyfunc(Kdata[[i]])}
for (i in (1:length(Mdata))) {Mdata[[i]] <- xyfunc(Mdata[[i]])}

Kshp <- list(); for (i in (1:length(Kdata))) {Kshp[i] <- spdf(Kdata[[i]],Kdata[[i]])}

Mshp <- list(); for (i in (1:length(Mdata))) {Mshp[i] <- spdf(Mdata[[i]],Mdata[[i]])}

Kbind <- do.call(bind, Kshp) 
Mbind <- do.call(bind, Mshp) 
#plot(Kbind);plot(Mbind)


x <- intersect(Kbind,Mbind)
#plot(x)

xdf <- data.frame(x)
xdf$icon <- "https://i.stack.imgur.com/z7NnE.png"

google_map(key = mapKey, location = c(mean(latmax,latmin), mean(lngmax,lngmin)), zoom = 8) %>% 
     add_markers(data = xdf, lat = "lat", lon = "lng", marker_icon = "icon")