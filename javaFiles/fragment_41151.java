public class First_Fragment extends Fragment {

        View myView;
        TextView tv;
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            myView = inflater.inflate(R.layout.first_layout, container, false);
         tv = (TextView) myView.findViewById(R.id.textView2);
            return myView;


        }



        public boolean executeCommand(){
            System.out.println("executeCommand");
            Runtime runtime = Runtime.getRuntime();
            try
            {
                Process  mIpAddrProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
                int mExitValue = mIpAddrProcess.waitFor();
                System.out.println(" mExitValue " + mExitValue);
                if(mExitValue==0){
                    return true;
                }else{
                    return false;
                }


                tv.setText(mExitValue);

            }
            catch (InterruptedException ignore)
            {
                ignore.printStackTrace();
                System.out.println(" Exception:"+ignore);
            }
            catch (IOException e)
            {
                e.printStackTrace();
                System.out.println(" Exception:"+e);
            }
            return false;


        }

    }