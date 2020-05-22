FragmentManager fm  = getFragmentManager();
FragmentA fragmentA = new FragmentA();
FragmentB fragmentB = new FragmentB();

// 1. Show A
fm.beginTransaction()
  .add(fragmentA, R.id.container)
  .commit();

// 2. Replace A with B
// FragmentManager keeps reference to fragmentA;
// it stays attached and created; fragmentB goes 
// through lifecycle methods onAttach(), onCreate()
// and so on.
fm.beginTransaction()
  .replace(fragmentB, R.id.container)
  .addToBackstack(null)
  .commit();

// 2'. Alternative to replace() method
fm.beginTransaction()
  .remove(fragmentA)
  .add(fragmentB, R.id.container)
  .addToBackstack(null)
  .commit();

// 3. Reverse (2); Result - A is visible
// What happens:
//   1) fragmentB is removed from container, it is detached now;
//      FragmentManager doesn't keep reference to it anymore
//   2) Instance of FragmentA is placed back in the container
// Now your Backstack is empty, FragmentManager is aware only
// of FragmentA instance
fm.popBackStack();

// 4. Show B
// Since fragmentB was detached, it goes through its early
// lifecycle methods: onAttach() and onCreate().
fm.beginTransaction()
  .replace(fragmentB, R.id.container)
  .addToBackstack(null)
  .commit();