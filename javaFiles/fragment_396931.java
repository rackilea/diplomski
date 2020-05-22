//Anyone can read only sign in users can write      
{
  "rules": {
    ".read": true,
    ".write": "auth != null"
  }
}