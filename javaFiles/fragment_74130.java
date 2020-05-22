// Check for Device wrt ADF pose, Device wrt Start of Service pose,
                // Start of Service wrt ADF pose (This pose determines if the device
                // is relocalized or not).
                if (pose.baseFrame == TangoPoseData.COORDINATE_FRAME_AREA_DESCRIPTION
                        && pose.targetFrame == TangoPoseData
                        .COORDINATE_FRAME_START_OF_SERVICE) {
                    if (pose.statusCode == TangoPoseData.POSE_VALID) {
                        mIsRelocalized = true;
                    } else {
                        mIsRelocalized = false;
                    }