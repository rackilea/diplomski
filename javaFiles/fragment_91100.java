try{
    Assert.assertTrue(test);
    resultado = TestLinkAPIResults.TEST_PASSED;
} catch (AsertionError e){
     resultado = TestLinkAPIResults.TEST_FAILED;
     nota = fraud.getError();
     e.printStackTrace();
 }finally{
     ResultadoExecucao.reportTestCaseResult(PROJETO, nombrePlan, nomTL_validacionCantidadMensajes, nombreBuild, nota, resultado);
 }