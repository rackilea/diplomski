@ApiResponses(value = { 
                        @ApiResponse(code = 200, message = "Successful retrieval of demand",responseContainer="List"),
                        @ApiResponse(code = 404, message = "Demand does not exist", response = Your Error response.class),
                        @ApiResponse(code = 500, message = "Internal server error", response = Your Error response.class) 
                    }
            )