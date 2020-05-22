double start_x1 = RoadList.get(i).getStartLatitude()-given latitude;
double start_x2 = RoadList.get(i).getStartLongitude()-given longitude;
start_x1 *= start_x1;
start_x2 *= start_x2;

double end_x1 = RoadList.get(i).getEndLatitude()-given latitude;
double end_x2 = RoadList.get(i).getEndLongitude()-given longitude;
end_x1 *= end_x1;
end_x2 *= end_x2;

double x = Math.sqrt(start_x1 + start_x2);
double y = Math.sqrt(end_x1 + end_x2);