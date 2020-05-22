service firebase.storage {
   match /b/sacred-age-861.appspot.com/o {
      match /{allPaths=**} {
         allow read, write;
      }
   }
}