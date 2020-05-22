sudo pip install -U crcmod
sudo gcloud auth activate-service-account --key-file=${HOME}/gcloud-service-key.json
sudo gcloud --quiet config set project ${GOOGLE_PROJECT_ID}
sudo gcloud firebase test android run \
           --type instrumentation \
           --app PATH_TO_APK \
           --test PATH_TO_TEST_APK \
           --device DEVICE_OF_YOUR_CHOOSING \
           --environment-variables coverage=true,coverageFile="/sdcard/coverage.ec" \
           --directories-to-pull=/sdcard \
           --results-dir=${CIRCLE_BRANCH}_${CIRCLE_BUILD_NUM}
sudo gsutil -m cp -r -U gs://test-lab-YOUR_LOCATION/${CIRCLE_BRANCH}_${CIRCLE_BUILD_NUM}/DEVICE/artifacts/coverage.ec app/build/outputs/code_coverage/LOCATION_OF_ANDROID_TESTS/connected/coverage.ec
sudo gsutil rm -r gs://test-lab-YOUR_LOCATION/${CIRCLE_BRANCH}_${CIRCLE_BUILD_NUM}