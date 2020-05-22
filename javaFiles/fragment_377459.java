ARCoreSession session = goARCoreDevice.GetComponent<ARCoreSession>();
ARCoreSessionConfig myConfig = session.SessionConfig;

DestroyImmediate(session);
// Destroy(session);

yield return null;

session = goARCoreDevice.AddComponent<ARCoreSession>();
session.SessionConfig = myConfig;
session.enabled = true;