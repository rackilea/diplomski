try
{
    myViewModel.insert();
}
catch (Exception e)
{
    Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    Log.i("ErroCriarConta", "criaConta: " + e);
}