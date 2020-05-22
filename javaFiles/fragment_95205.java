function UploadMessage() {
       <% if(((String)request.getAttribute("SuccessMessage")).equals("Uploaded successfully")) { %>
            alert("File Successfully uploaded !");
        <% 
         } %>
    }