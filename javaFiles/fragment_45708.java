{
  "rules": {

    "stores": {
            ".read": "auth != null && (root.child('readUsers').hasChild(auth.uid) || root.child('readWriteUsers').hasChild(auth.uid))",
            ".write": "auth != null && root.child('readWriteUsers').hasChild(auth.uid)"
      },

    "readUsers": {
            ".read": "auth != null && root.child('readUsers').hasChild(auth.uid)",
            ".write": false   
    },


    "readWriteUsers": {
            ".read": "auth != null && root.child('readWriteUsers').hasChild(auth.uid)",
            ".write": false   
    }

  }
}