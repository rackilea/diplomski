switch (item.getItemId()) {
            case R.id.navigation_home:
                mTextMessage.setText(R.string.title_home);
                switchToFragment1();
                break;

            case R.id.navigation_dashboard:
                mTextMessage.setText(R.string.title_dashboard);                    
                switchToFragment2();
                break;

            case R.id.navigation_notifications:
                mTextMessage.setText(R.string.title_notifications);                     
                switchToFragment3();
                break;
        }