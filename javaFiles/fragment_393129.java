@Override
public void finish()
{
    if (pDialog != null && pDialog.isShowing())
    {
         pDialog.dismiss();
    }
}