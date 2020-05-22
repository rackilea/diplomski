getSupportFragmentManager().beginTransaction()
        .replace(R.id.container, locationFragment)
        .replace(R.id.container, summaryFragment)
        .replace(R.id.container, typeFragment)
        .replace(R.id.container, countFragment)
        .commit();