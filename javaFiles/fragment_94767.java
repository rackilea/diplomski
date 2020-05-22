admin.auth().getUserByPhoneNumber(phoneNumber)
  .then(function(userRecord) {
    // User found.
  })
  .catch(function(error) {
    console.log("Error fetching user data:", error);
  });