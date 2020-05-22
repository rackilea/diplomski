/*  Get file from jsp  */
UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
File file = uploadRequest.getFile("XXX", true); // XXX is the input name from my jsp
FileInputStream fileInput = new FileInputSream(file);
OutputBlob blobOutput = new OutputBlob(fileInput, file.length());

/*  Attachment Object Properties  */
long attachment_id = CounterLocalServiceUtil.increment();
attachments a = null;
a = attachmentsLocalServiceUtil.createattachments((int) attachment_id);
a.setNbi_clearance(blobOutput);

/*  Save the data to table  */
a = attachmentsLocalServiceUtil.addattachments(a);