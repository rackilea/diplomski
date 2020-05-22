<form action="${request.contextPath}/path/to/controller" method="POST" enctype="multipart/form-data">
    File to upload:
    <input type="file" name="fileData" />
    <br />
    <!-- probably more fields, depending on your requirements... -->
    <input type="submit" value="Upload file">
</form>