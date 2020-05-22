Authentication authRequest = new UsernamePasswordAuthenticationToken(username+"@0@"+password+"@0@"+response.getOperatorInfo().getRole_name(), password);

                    Authentication result=null;
                    try {
                        result = authenticationManager.authenticate(authRequest);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    SecurityContextHolder.getContext().setAuthentication(result);