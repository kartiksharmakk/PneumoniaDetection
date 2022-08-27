## Android Implementation 
Android app (https://github.com/kartiksharmakk/PneumoniaDetection/tree/main/android) using Tensorflow Lite Support Library . 

<img src="https://user-images.githubusercontent.com/77577353/185475647-d14bd5fe-3458-4066-a244-1e57cfcbbd50.gif" width="30%" height="30%"/>
Apk can also be downloaded from Github Release of this repository

## 💁‍♂️ How to build Android Implementation locally
- Clone The Repo and open Android Studio inside the `android` folder
- Android Studio will sync the gradle and user can then run the app on Emulator 


## Web Implementation using Python Flask 
https://github.com/kartiksharmakk/PneumoniaDetection/tree/main/web
local implementation tested using conda terminal 


https://user-images.githubusercontent.com/77577353/186962357-59ff7d4e-cc91-47fc-908b-fa86120cd139.mp4


## 💁‍♂️ How to build Web Implementation locally
- Clone The Repo and open `web` directory
- Install Python requirements `pip install -r requirements.txt`
- Start the server for development `python app.py` or `python3 app.py `


## Model Visualized

- CNN Tensorflow Lite Model trained on https://www.kaggle.com/paultimothymooney/chest-xray-pneumonia Dataset 
- Model Has An Accuracy of 92%
- Model gives prediction within range of 0 (tending to normal)  and 1 (tending to pneumonic) , to be sure that pneumonic people arent classified as normal , I have set   parameter above 0.2 to denote pneumonic


<img src="https://raw.githubusercontent.com/kartiksharmakk/PneumoniaDetection/main/model/pneumonia_detection_visualized.png" width="30%" height="25%"/>
