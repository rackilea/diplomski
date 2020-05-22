@Test
public void testStatus() 
{
    String response = 
            given()
               .contentType("application/json")
               .body(assignment)
            .when()
               .post("videoAssignments")
               .peek() // Use peek() to print the ouput
            .then()
                .statusCode(201) // check http status code
                .body("assignmentId", equalTo("584")) // whatever id you want
            .extract()
                .asString();

    assertNotNull(response);
}