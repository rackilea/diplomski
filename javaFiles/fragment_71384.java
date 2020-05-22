@Test
public void saveNewDocumentShare(){
    SharedDocument sharedDocument = new SharedDocument();
    sharedDocument.setDocument(document1);
    sharedDocument.setSharedBy(teacher1);
    sharedDocument.setSharedWith(teacher2);
    sharedDocument.setSharedDate(new Date());

    sharedDocument.setCreatedBy("1");
    sharedDocument.setCreatedDate(new Date());
    sharedDocument.setModifiedBy("1");
    sharedDocument.setModifiedDate(new Date());


    SharedDocument savedSharedDocument = dao.saveSharedDocument(sharedDocument);

    assertNotNull(savedSharedDocument);
    assertThat(savedSharedDocument.getId(),notNullValue());
}

@Test
public void saveNewPostShare(){
    SharedPost sharedWikiPage = new SharedWikiPage();
    sharedPost.setPost(post1);
    sharedPost.setSharedBy(teacher1);
    sharedPost.setSharedWith(teacher2);
    sharedPost.setSharedDate(new Date());

    sharedPost.setCreatedBy("1");
    sharedPost.setCreatedDate(new Date());
    sharedPost.setModifiedBy("1");
    sharedPost.setModifiedDate(new Date());


    SharedPost savedSharedPost = dao.saveSharedPost(sharedPost);

    assertNotNull(savedSharedPost);
    assertThat(savedSharedPost.getId(),notNullValue());

}