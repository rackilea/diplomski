.....

gender: {
         title: 'Gender',
         key: true
},

homeNo: {
        title: 'Home-No',
        key: true,
        display:function(data){
                   return data.record.address.homeNo;
        }
},
street: {
        title: 'Street',
        key: true,
        display:function(data){
                   return data.record.address.street;
           }
},
city: {
      title: 'City',
      key: true,
      display:function(data){
                return data.record.address.city;
      }
},
province: {
           title: 'Province',
           key: true,
           display:function(data){
                     return data.record.address.province;
           }
},
firstName: {
        title: 'First Name',
        display:function(data){
                   return data.record.name.firstName;
        }
},
middleName: {
        title: 'Middle Name',
        display:function(data){
                  return data.record.name.middleName;
        }
},
lastName: {
        title: 'Last Name',
        display:function(data){
                  return data.record.name.lastName;
        }
},

........