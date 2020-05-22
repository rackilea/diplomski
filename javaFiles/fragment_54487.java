@Test
public void AskTheUser_WhenUserSaysYes_WeThankHim()
{
    // Arrange
    bool answer = true;

    MockMessageDisplayer message = new MockMessageDisplayer();
    MockDialogDisplayer dialog = new MockDialogDisplayer(answer);

    AskTheUserController controller =
        new AskTheUserController(dialog, message);

    // Act
    controller.AskTheUser();

    // Assert
    Assert.AreEqual("OK, thank you!", message.displayedMessage);
}

@Test
public void AskTheUser_WhenUserSaysNo_WeLetHimChangeHisMind()
{
    // Arrange
    bool answer = true;

    MockMessageDisplayer message = new MockMessageDisplayer();
    MockDialogDisplayer dialog = new MockDialogDisplayer(answer);

    AskTheUserController controller =
        new AskTheUserController(dialog, message);

    // Act
    controller.AskTheUser();

    // Assert
    Assert.IsTrue(
        message.displayedMessage.contains("change your mind"));
}