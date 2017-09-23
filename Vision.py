import requests
from google.cloud import vision
from google.cloud.vision import types


credentials = GoogleCredentials.get_application_default()


textOutput = requests.post('https://vision.googleapis.com/v1/images:annotate?key=AIzaSyAlktW0JsCeMpjwLVQ86xcujUMmrGUfGtk',{
  "requests": [
    {
      "image": {
            "source":{
                "imageUri":
                "gs//mhacks-180805/MPW-38880.jpeg"
      },
      "features": [
        {
          "type": "TEXT_DETECTION"
        }
      ]
    }
  ]
})


labels = textOutput.label_annotations

print('Labels:')
for label in labels:
    print(label.description)