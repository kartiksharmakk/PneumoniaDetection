Model gives prediction within range of 0 (tending to normal)  and 1 (tending to pneumonic) , to be sure that pneumonic people arent classified as normal , I have set parameter above 0.2 to denote pneumonic

<img src="https://user-images.githubusercontent.com/77577353/185475647-d14bd5fe-3458-4066-a244-1e57cfcbbd50.gif" width="30%" height="30%"/>

CNN Tensorflow Lite Model trained on https://www.kaggle.com/paultimothymooney/chest-xray-pneumonia Dataset And Integrated inside Android app (https://github.com/kartiksharmakk/PneumoniaDetection/tree/main/android) using Tensorflow Lite Support Library . 

Apk can be downloaded from Github Release of this repository


Web Implementation using Python Flask ( Clicking Reload button clears the Cache and resets the website )

https://user-images.githubusercontent.com/77577353/186962357-59ff7d4e-cc91-47fc-908b-fa86120cd139.mp4


Model Has An Accuracy of 92%

Model Visualized

<img src="https://raw.githubusercontent.com/kartiksharmakk/PneumoniaDetection/main/model/pneumonia_detection_visualized.png" width="30%" height="25%"/>
