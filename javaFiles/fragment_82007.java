switch (action){
        case 0:
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            break;
       ...
        default:
            Log.i("distribution", "default case selected with action = " + action);
            }