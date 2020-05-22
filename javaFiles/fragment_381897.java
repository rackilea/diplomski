public string deviceName;
WebCamTexture wct;
void Start ()
{
    WebCamDevice[] devices = WebCamTexture.devices;
    deviceName = devices[0].name;
    wct = new WebCamTexture(deviceName, 400, 300, 12);
    GetComponent<Renderer> ().material.mainTexture = wct;
    wct.Play();
}