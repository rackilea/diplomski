/**
 * Override this method to expose the {@link AuthenticationManager} from
 * {@link #configure(AuthenticationManagerBuilder)} to be exposed as
 * a Bean. For example:
 *
 * <pre>
 * &#064;Bean(name name="myAuthenticationManager")
 * &#064;Override
 * public AuthenticationManager authenticationManagerBean() throws Exception {
 *     return super.authenticationManagerBean();
 * }
 * </pre>
 *
 * @return the {@link AuthenticationManager}
 * @throws Exception
 */
public AuthenticationManager authenticationManagerBean() throws Exception {
    return new AuthenticationManagerDelegator(authenticationBuilder);
}