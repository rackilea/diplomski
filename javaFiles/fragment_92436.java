usedImages = []
for numbers 0 to 19 {
   let num = false
   while (!num) {
     let tempNum = Math.floor(Math.random() * 10);
     if (!( usedImages.includes(tempNum)){
        num = tempNum
     }
   }

   var allBooks = db.collectionGroup('MyBooks').where('imageKey', '==', num);
     allBooks.get().then(function (querySnapshot) {
        querySnapshot.forEach(function (doc) {
        console.log(doc.id, ' => ', doc.data());
     });
   });

}