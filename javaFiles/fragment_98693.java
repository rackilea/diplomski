package com.example.junior_yao.fragmentfrombeginning;


       import android.os.Bundle;
       import android.support.annotation.Nullable;
       import android.support.v4.app.Fragment;
       import android.view.LayoutInflater;
       import android.view.View;
       import android.view.ViewGroup;


         public class Top_Fragment extends Fragment {



         public Top_Fragment() {
        }


         @Override
         public View onCreateView(LayoutInflater inflater, ViewGroup   container,
                         Bundle savedInstanceState) {

         return inflater.inflate(R.layout.fragment_top, container, false);
}

         @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
         super.onActivityCreated(savedInstanceState);
            }
         }