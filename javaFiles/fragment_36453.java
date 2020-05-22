JPAQuery<Tuple> query = new JPAQuery<Tuple>(entityManager);
        QPGUserRoles pgUserRoles = QPGUserRoles.pGUserRoles;
        List<Tuple> dataList = query
                .from(pgUserRoles)
                .select(pgUserRoles.roleId,
                        pgUserRoles.roleName,
                        pgUserRoles.roleType,
                        pgUserRoles.status)
                .where(isRoleName(userRolesDTO.getRoleName()),
                        isRoleType(userRolesDTO.getRoleType()),
               isStatus(userRolesDTO.getStatus()),
               isStatusNotEq()
                )
                .offset(offset)
                .limit(limit)
                .orderBy(orderByRoleIdDesc())
                .fetch();