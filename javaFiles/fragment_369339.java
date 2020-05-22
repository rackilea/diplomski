Mockito.doReturn(facesContextMock).when(resourcesMock).produceFacesContext();
// Execute Method
cut.warning("SOME_DETAIL_TEXT");
// Verify interactions with the Resources and Faces and maybe others...
verify(resourcesMock).produceFacesContext();
verify(facesContextMock).addMessage(Mockito.anyString() ,
                facesMessageCaptor.capture());
verifyNoMoreInteractions(...., resourcesMock, facesContextMock);
// write assert (i´ve used hamcrast-corematchers - more readable)
actualMessage = (FacesMessage) facesMessageCaptor.getValue();
assertThat(FacesMessage.SEVERITY_WARN, is(equalTo(actualMessage.getSeverity())));
assertThat(MY_TITLE, is(equalTo(actualMessage.getSummary())));
assertThat("DETAIL_TEXT", is(equalTo(actualMessage.getDetail())));