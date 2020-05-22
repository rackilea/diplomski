// try re-login
          if (UserGroupInformation.isLoginKeytabBased()) {
            UserGroupInformation.getLoginUser().reloginFromKeytab();
          } else if (UserGroupInformation.isLoginTicketBased()) {
            UserGroupInformation.getLoginUser().reloginFromTicketCache();
          }