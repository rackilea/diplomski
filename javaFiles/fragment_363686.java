String invite = LogInUtil.getInvite(this);

            if ( invite != null && !"null".equals(invite)){

                System.out.println(invite);
                System.out.println("=============================================="+(invite != null));
                Invitation.setInvite(Long.valueOf(invite));
            }