@Component
class SpringSecurityAuditorAware : AuditorAware<String> {

    override fun getCurrentAuditor(): Optional<String> {
        return Optional.ofNullable(SecurityContextHolder.getContext()?.authentication)
                .filter { authentication -> authentication.isAuthenticated }
                .map { authentication -> authentication.principal as Jwt }
                .map { jwt -> jwt.claims["sub"] as String? }
    }

}