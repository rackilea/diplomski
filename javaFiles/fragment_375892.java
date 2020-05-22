import java.util.HashMap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class Fragment12 extends SherlockFragment {
    //create hashmap
            private HashMap<Marker, Integer> hash = new HashMap<Marker, Integer>();
            private HashMap<Marker, Class<?>> hashclass = new HashMap<Marker, Class<?>>();
           //

            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
                View rootView = inflater.inflate(R.layout.fragment12, null);
                return rootView;
            }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState){
        super.onViewCreated(v, savedInstanceState);

    final LatLng Initial = new LatLng(-34.673009, -58.474111);
    final LatLng FADU = new LatLng(-34.542163, -58.443716);
    final LatLng UNO = new LatLng(-34.524924, -58.576421);
    final LatLng DOS = new LatLng(-34.603489, -58.439344);
    final LatLng TRES = new LatLng(-34.646890, -58.513357);
    final LatLng CUATRO = new LatLng(-34.512189, -58.489223);
    final LatLng CINCO = new LatLng(-34.617692, -58.376514);
    final LatLng SEIS = new LatLng(-34.744174, -58.252917);
    final LatLng SIETE = new LatLng(-34.578326, -58.439691);
    final LatLng OCHO = new LatLng(-34.606389, -58.458911);
    final LatLng NUEVE = new LatLng(-34.756687, -58.402807);
    final LatLng DIEZ = new LatLng(-34.621184, -58.483144);


GoogleMap googlemap;

        googlemap  = ((SupportMapFragment)  getFragmentManager().findFragmentById(R.id.map12)).getMap();

        googlemap.setMyLocationEnabled(true);
        googlemap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(Initial, 10);
        googlemap.animateCamera(update);


        //modify
        Marker marker1 = googlemap.addMarker(new MarkerOptions().position(FADU).title("FADU").snippet("Facultad de Arquitectura, Diseño y Urbanismo").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker1)));
        hash.put(marker1, R.drawable.logo);
        hashclass.put(marker1, Contacto.class);


            .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker2)));
    hash.put(marker11, R.drawable.renderak);
    hashclass.put(marker11, RenderAK.class);

    googlemap.setOnInfoWindowClickListener(new OnInfoWindowClickListener(){

        @Override
        public void onInfoWindowClick(Marker marker) {
            // TODO Auto-generated method stub
            Class<?> cls = hashclass.get(marker);
            Intent i = new Intent(getActivity(), cls);
            startActivity(i);
        }
    });

    googlemap.setInfoWindowAdapter(new InfoWindowAdapter() {

     @Override
     public View getInfoWindow(Marker marker) {

     View v = getLayoutInflater(null).inflate(R.layout.infowindow, null);

     TextView titulo = (TextView) v.findViewById(R.id.titulo);
     TextView direccion = (TextView) v.findViewById(R.id.direccion);
     ImageView imagen = ((ImageView)v.findViewById(R.id.imagen));

     titulo.setText(marker.getTitle());
     direccion.setText(marker.getSnippet());

     if(hash.get(marker) != null)
        imagen.setImageDrawable(getResources().getDrawable(hash.get(marker)));

     return v;

    }
        //..
     @Override
        public View getInfoContents(Marker marker) {
            // TODO Auto-generated method stub
            return null;
        }
     });
    }
@Override
public void onPause() {
    super.onPause();

 }
@Override
public void onDestroyView() {

    super.onDestroyView(); 
    Fragment fragment = (getFragmentManager().findFragmentById(R.id.map12));  
    if (fragment != null){
        getActivity().getSupportFragmentManager().beginTransaction()
        .remove(fragment)
        .commit();          
        }      
    }
}