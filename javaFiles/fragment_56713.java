val captureCallback = object : CameraCaptureSession.CaptureCallback() {

            override fun onCaptureCompleted(session: CameraCaptureSession,
                                            request: CaptureRequest,
                                            result: TotalCaptureResult) {
                sendBackResult(mFile)
            }
        }

        mCaptureSession!!.capture(captureBuilder.build(), captureCallback, mBackgroundHandler)
    } catch (e: CameraAccessException) {
        e.printStackTrace()
    }