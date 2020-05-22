[
  {
    "operation": "shift",
    "spec": {
      "Data": {
        "ROOT": {
          "MODIFIED_DATE": "modifiedDate",
          "A1": {
            "*": {
              "FLD1": "a1[&1].fld1",
              "A2": {
                "*": {
                  "FLD2": "a1[&3].a2[&1].fld2"
                }
              }
            }
          }
        }
      },
      "metaData": {
        "FLD3": "fld3"
      }
    }
    },
  {
    "operation": "default",
    "spec": {}
    }
]