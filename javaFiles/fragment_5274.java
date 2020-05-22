Fragment firstFragment= new Sketch();
Fragment secondFragment= new Sketch();

    FragmentManager fragmentManager= getFragmentManager();
    fragmentManager.beginTransaction()
            .replace(R.id.contenedor, firstFragment)
            .commit();

    fragmentManager.beginTransaction()
            .replace(R.id.contenedor2, secondFragment)
            .commit();