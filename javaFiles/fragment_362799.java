package org.apache.shiro.samples.web;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.*;

import java.util.Collection;
import java.util.Collections;

public class SimpleRolePermissionResolver implements RolePermissionResolver, PermissionResolverAware {

    private PermissionResolver permissionResolver = new WildcardPermissionResolver();

    public void setPermissionResolver(PermissionResolver permissionResolver) {
        this.permissionResolver = permissionResolver;
    }

    public Collection<Permission> resolvePermissionsInRole(String roleString) {
        return Collections.<Permission>singleton(permissionResolver.resolvePermission(roleString));
    }
}