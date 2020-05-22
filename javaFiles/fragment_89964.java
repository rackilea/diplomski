try {
        loadedUser = this.getUserDetailsService().loadUserByUsername(username);
    } catch (UsernameNotFoundException notFound) {
        throw notFound;
    } catch (Exception repositoryProblem) {
        throw new AuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
    }

    if (loadedUser == null) {
        throw new AuthenticationServiceException(
                "UserDetailsService returned null, which is an interface contract violation");
    }