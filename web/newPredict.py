from keras.models import load_model
from keras.preprocessing.image import load_img
from keras.preprocessing.image import img_to_array
from keras.applications.vgg16 import preprocess_input
from keras.applications.vgg16 import decode_predictions
from keras.applications.vgg16 import VGG16
import numpy as np
from PIL import ImageFile
from keras.models import load_model

ImageFile.LOAD_TRUNCATED_IMAGES = True
model = load_model('pneumonia')
def newPredict():
    image = load_img('./static/img/user_input.jpeg', target_size=(150, 150))
    img = np.array(image)
    img = img / 255.0
    img = img.reshape(1,150,150,3)
    res = model.predict(img)
    predictionResult='default'
    predictionValue=-1
    
    if (res[0][0]>0.2):
        predictionResult='Pneumonic'
        predictionValue=res[0][0]
    else:
        predictionResult='Normal'
        predictionValue=res[0][0]
    return predictionResult,predictionValue