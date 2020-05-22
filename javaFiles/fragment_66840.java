{
  "rules": {
    "shift-assigns": {
      "$shiftid": {
        "$uid": {
          ".validate": "root.child('/shifts/$shiftid/numSignups').val() < root.child('/shifts/$shiftid/numOfEmps').val()"
        }
      }
    }
  }
}