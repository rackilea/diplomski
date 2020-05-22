@Path("/social/facebook/update")
        public class FacebookRealtimeAPIResource
        {
            private static final String HUB_MODE = "hub.mode";
            private static final String HUB_CHALLENGE = "hub.challenge";
            private static final String HUB_VERIFY_TOKEN = "hub.verify_token";

            public FacebookRealtimeAPIResource()
            {
                // any desired implementation here
            }

            @GET
            @Produces(MediaType.TEXT_HTML)
            public void validateFacebookRequest(
            @DefaultValue("") @QueryParam(HUB_MODE) String hubMode,
            @DefaultValue("") @QueryParam(HUB_CHALLENGE) String hubChallenge,
            @DefaultValue("") @QueryParam(HUB_VERIFY_TOKEN) String hubVerifyToken,
            @Context HttpServletRequest request,
            @Context HttpServletResponse response)
            {

                try
                {
                    // hubVerifyToken based validation if desired       
                    response.setStatus(HttpServletResponse.SC_OK);
                    response.getWriter().write(hubChallenge);
                    response.getWriter().flush();
                    response.getWriter().close();
                }
                catch (IOException exc)
                {
                    throw new WebApplicationException(Response.Status.BAD_REQUEST);
                }
            }

            @POST
            @Consumes(MediaType.APPLICATION_JSON)
            public void processFacebookRealtimeUpdate(@Context HttpServletRequest request, InputStream inputStream)
            {
                StringBuilder sb = new StringBuilder();
                String newLine = System.getProperty("line.separator");
                String line;
                String json = "";

                try
                {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, request.getCharacterEncoding()));
                    while ((line = reader.readLine()) != null)
                    sb.append(line).append(newLine);
                }
                catch (Exception exc)
                {
                    throw new WebApplicationException(Response.Status.BAD_REQUEST);
                }
                json = sb.toString(); // use this json string for desired purpose
            }
        }