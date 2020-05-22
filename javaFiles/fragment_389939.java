Parse.cloud.define('formerFriends', async request => {
  const query = new Parse.Query(Parse.User);
  query.notEqualTo('username', request.user.getUsername());
  query.notContainedIn('username', request.user.get('Former_friends'));
  const objects = await query.find({ useMasterKey: true });
  if (object.length > 0) {
    const aList = request.user.get('Former_friends');                                                
    aList.add(objects[0].getUsername());
    request.user.set('Former_friends', aList);
    await request.user.save();
    const userfound = objects[0];
    userfound.set('Name', 'Any String');
    await userfound.save(null, { useMasterKey: true });
  }
});