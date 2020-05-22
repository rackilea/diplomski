// This creates an "empty" JS object, with no properties.
var json2Send = new Object();
var length = location.href.length;
// Adding a property is as easy as just setting it, it will be created by this.
json2Send.boss = location.href.substring(length - 5, length - 4);
if (document.newLive.bval.value == '') {
  json2Send.bands = [];
} else {
  json2Send.bands = [document.newLive.bval.value];
}
json2Send.data = document.newLive.dateEvent.value;
// Properties can also be other objects, here created with the
// object literal notation of { key:value, ...}.
json2Send.address = {
  // Inside, it's just another JS object again,
  // this time setting properties with literal notation key:value
  // Note how there's no need to quote anything here!
  street: document.newLive.street.value,
  number: document.newLive.number.value,
  city: document.newLive.city.value,
  region: document.newLive.region.value,
  state: document.newLive.state.value
};