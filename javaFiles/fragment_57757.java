[
  {
    "operation": "shift",
    "spec": {
      "emps": {
        "*": {
          "emp": {
            "empId": "data.result[0].emps[&2].empId",
            "name": "data.result[0].emps[&2].name",
            "phoneNumber": "data.result[0].emps[&2].phone",
            "emailAddress": "data.result[0].emps[&2].email"
          }
        }
      }
    }
  },
  {
    "operation": "default",
    "spec": {
      "data": {
        "result[]": {
          "*": {
            "emps[]": []
          }
        }
      }
    }
  }
]