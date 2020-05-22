if (Modifier.isProtected(mods) &&
                refKind == REF_invokeVirtual &&
                m.getDeclaringClass() == Object.class &&
                m.getName().equals("clone") &&
                refc.isArray()) {
            // The JVM does this hack also.
            // (See ClassVerifier::verify_invoke_instructions
            // and LinkResolver::check_method_accessability.)
            // Because the JVM does not allow separate methods on array types,
            // there is no separate method for int[].clone.
            // All arrays simply inherit Object.clone.
            // But for access checking logic, we make Object.clone
            // (normally protected) appear to be public.
            // Later on, when the DirectMethodHandle is created,
            // its leading argument will be restricted to the
            // requested array type.
            // N.B. The return type is not adjusted, because
            // that is *not* the bytecode behavior.
            mods ^= Modifier.PROTECTED | Modifier.PUBLIC;
        }