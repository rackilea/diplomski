@Then("^Last step to run for last scenario (\\d+)$")
public void lastStep(int size) {

    // Will be called only for last scenario in examples... 
    if(size==getCurrentExamplesRow()) {

    }
}