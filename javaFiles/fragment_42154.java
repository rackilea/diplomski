Future<void> showTemperature() async { // making this both a Future and async method
 final databaseRefences = await FirebaseDatabase.instance.reference().child("Monitoring").child("Suhu");
 databaseReferences.once().then((Datasnapshot snapshot){
  Map <dynamic, dynamic> values = snapshot.value;
  values.forEach((key, values){
    print(value); // omitting "[keys]" from the OPs approach
   });
 });
}