int files = 0;

void draw(){
  saveJSONObject(whatever, "scraped" + files + ".json");
  files++;
}