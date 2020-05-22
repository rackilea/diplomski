names?.collect{[it:getSomeList(it)]} 

//sometimes you need to flatten in this case I dont think you would
names?.collect{[it:seriesHotelList(it)]}?.flatten() 

List getSomeList(String name) {
  return ['task1','task2']
}