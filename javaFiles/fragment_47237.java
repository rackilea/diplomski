@Test(expected = FxRobotException.class)
public void fxIdNotExist() {
    clickOn("#test123");
}

@Test
public void allComponentsShouldHaveRightText() {
    verifyThat("#jfxButtonCheck", hasText("PRÜFEN"));
    verifyThat("#jfxButtonNextArithmeticProblem", hasText("NÄCHSTE AUFGABE"));
    verifyThat("#jfxButtonSave", hasText("SPEICHERN"));
    verifyThat("#jfxTextFieldResult", hasText(""));
}