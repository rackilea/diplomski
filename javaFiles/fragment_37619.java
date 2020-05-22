Process createUser = buildProcess(
            "/bin/su",
            "-c",
            "/opt/vmware/vpostgres/current/bin/psql --command " + commandForUserCreation + " --dbname mydbname",
            myuser
            );