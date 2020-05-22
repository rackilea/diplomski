FragmentNames name = getIntent().getSerializableExtra(FRAGMENT_EXTRA);
switch(name) {
case FIRST_FRAGMENT:
//do stuff
break;
case SECOND_FRAGMENT:
//do stuff
break;
default:
//load default fragment(FirstFragment for example)
}