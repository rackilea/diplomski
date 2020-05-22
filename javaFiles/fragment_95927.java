@Component
public class PermissionEvaluatorImpl implements PermissionEvaluator {

@Override
public boolean hasPermission(Authentication auth,
    Object entity, Object permission) {

        // return true only if auth has the given
        // permission for the customer.
        // Current user can be obtained from auth.
}

...

}