const functions = require('firebase-functions');
//const GeoFire = require('geofire');

const admin = require('firebase-admin');
admin.initializeApp();

exports.searchNearbyLatLng = functions.runWith({ memory: '1GB', timeoutSeconds: 120 }).https.onRequest((request, response) => {

  let lat1Param = request.query.originlat;
  let lng1Param = request.query.originlng;
  let lat2Param = request.query.destLat;
  let lng2Param = request.query.destLng;

  let rootRef = admin.database().ref('riders_online').orderByChild('isUserRequested').equalTo('false');
  rootRef.once('value', gotData, errData);

  // The data comes back as an object
  function gotData(data) {
    let items = data.val();
    // Grab all the keys to iterate over the object
    let keys = Object.keys(items);
    // Loop through array
    for (let i = 0; i < keys.length; i++) {
      let key = keys[i];
      let item = items[key];
      console.log(item.isUserRequested, item.riderOriginLatitude, key);
      //response.json(data.val());

      let distance = getDistance( lat1Param, lng1Param, item.riderOriginLatitude, item.riderOriginLongitude );
      if( distance < 1 ) {
        let dist = getDistance( lat2Param, lng2Param, item.riderDestinationLatitude, item.riderDestinationLongitude );
        if( dist < 1 ) {
          let jsonData = {
            "info": {
              "createdAt": item.info.createdAt,
              "riderBirthDate": item.info.riderBirthDate,
              "riderDistrict": item.info.riderDistrict,
              "riderEmail": item.info.riderEmail,
              "riderFullName": item.info.riderFullName,
              "riderGender": item.info.riderGender,
              "riderImageUrl": item.info.riderImageUrl,
              "riderLicense": item.info.riderLicense,
              "riderNid": item.info.riderNid,
              "riderPhoneNumber": item.info.riderPhoneNumber,
              "riderToken": item.info.riderToken,
              "riderVehicle": item.info.riderVehicle,
              "riderVehicleNo": item.info.riderVehicleNo
            },
            "isUserRequested": item.isUserRequested,
            "riderAvailableTime": item.riderAvailableTime,
            "riderDestinationLatitude": item.riderDestinationLatitude,
            "riderDestinationLongitude": item.riderDestinationLongitude,
            "riderOriginLatitude": item.riderOriginLatitude,
            "riderOriginLongitude": item.riderOriginLongitude,
            "riderPrice": item.riderPrice,
            "riderToken": item.riderToken
          }
          response.json(jsonData);
        }
      }
    }

  }

  function errData(error) {
    console.log("Something went wrong.");
    console.log(error);
  }

  function getDistance( latitude1, longitude1, latitude2, longitude2 ) {
    let earth_radius = 6371;
    let dLat = degToRad( latitude2 - latitude1 );
    let dLng = degToRad( longitude2 - longitude1 );
    let a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(degToRad(latitude1)) * Math.cos(degToRad(latitude2)) * Math.sin(dLng/2) * Math.sin(dLng/2);
    let c = 2 * Math.asin(Math.sqrt(a));
    let d = earth_radius * c;
    return d;
  }

  function degToRad(degrees){
    let pi = Math.PI;
    return degrees * (pi/180);
  }

}, err => {
    console.error(err.stack);
    response.status(500).send('Unexpected error.');
});