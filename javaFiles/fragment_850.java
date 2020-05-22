import cloudstorage as gcs
import endpoints
import os

from google.appengine.api import app_identity
from protorpc import messages
from protorpc import message_types
from protorpc import remote

class Base64File(messages.Message):
    file = messages.BytesField(1, required=True, variant=messages.Variant.BYTES)

class ResponseMSG(messages.Message):
    message = messages.StringField(1)

FILE_RESOURCE = endpoints.ResourceContainer(Base64File,
                                            file_name=messages.StringField(2,required=True),
                                            content_type=messages.StringField(3,required=True))

@endpoints.api(name='gcsuploadapi', version='v0.1',
                                      description='Upload a file to GCS.')
class GCSUploadAPI(remote.Service):
    @endpoints.method(FILE_RESOURCE, ResponseMSG,
                        path='upload/{file_name}', http_method='POST',
                        name='upload.file')
    def upload_file(self, request):
        # get app default bucket and prepare filename (project should have billing enabled)
        bucket_name = os.environ.get('BUCKET_NAME',
                                 app_identity.get_default_gcs_bucket_name())
        bucket = '/' + bucket_name
        filename = bucket + '/' + request.file_name

        # create file (request.content_type contains MIME type submitted)
        write_retry_params = gcs.RetryParams(backoff_factor=1.1)
        gcs_file = gcs.open(filename, 'w',
                            content_type=request.content_type,
                            retry_params=write_retry_params)
        gcs_file.write(request.file)
        gcs_file.close()

        return ResponseMSG(message="done")

app = endpoints.api_server([GCSUploadAPI])