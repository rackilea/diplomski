resultTable = $('#changeTable').DataTable({
  ...,
  columns: [
     { data: 'id', title: 'id' },
     { data: 'createdDate', title: 'createdDate' },
     { data: 'source', title: 'source' },
     { data: 'emailId', title: 'emailId' },
     { data: 'attachmentId', title: 'attachmentId' }
   ]
})