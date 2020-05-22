import argparse
import requests
from requests_toolbelt import MultipartEncoder

parser = argparse.ArgumentParser()
parser.add_argument('message')
parser.add_argument('--files', nargs='+')
args = parser.parse_args()

multipart_form_data_object = MultipartEncoder(
    fields=(
        ('files', (args.files[0], open(args.files[0], 'rb'), "application/json")),
        ('files', (args.files[1], open(args.files[1], 'rb'), "application/json")),
        ('message', ('message', open(args.message, 'rb'), 'application/json')),
    )
)

res = requests.post('http://localhost:8000', data=multipart_form_data_object, headers={'Content-Type': multipart_form_data_object.content_type})
print(res.content)