service cloud.firestore {
  match /databases/{database}/documents {
    match /Users/{userId} {
      allow read, update, delete: if request.auth.uid == userId;
      allow create: if request.auth.uid != null;
    }
  }
}