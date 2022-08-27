from flask import Flask , render_template , request
from newPredict import newPredict
import os
#__name__ = __main__
app = Flask(__name__)

@app.route('/',methods=['GET'])
def hello():
    param = request.args.get('Reload')
    
    if param == 'Reload':
        os.remove('./static/img/user_input.jpeg')
        return render_template('index.html')
    else:
        return render_template('index.html')

app.config['IMAGES_UPLOAD'] = '/static/img/'
@app.route("/", methods=['POST'])
def postHello():
    if request.method=='POST':
        f=request.files['image']
        path='./static/img/user_input.jpeg'
        dst = open(path,'wb')
        f.save(dst)
        Result,Value=newPredict()
        dst.close()
        result_dict={
            'result':Result,
            'value':Value
        }
        return render_template("index.html",final_result=result_dict)

if __name__ == '__main__':
    app.run(debug=True, port=os.getenv("PORT", default=5000))
