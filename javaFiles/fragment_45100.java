public UserBoxGLBFragment getMyFragment(){
          Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.FrameLayoutContainer); 
                if (fragment instanceof UserBoxGLBFragment){
                    return (UserBoxGLBFragment)fragment;
                }
                return null;

    }