package com.example.pneumoniadetection

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import com.example.pneumoniadetection.ml.PneumoniaDetection
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer
import java.nio.ByteOrder

class Analyzer(context: Context) {
    private var mContext = context
    var FinalResult=ClassificationDataClass("default",-1.1f)



    //fun classify(bitmap: Bitmap, callback: (Classifier) -> Unit) {

    fun classify(bitmap: Bitmap):ClassificationDataClass{



        val shapedBitmap = Bitmap.createScaledBitmap(bitmap, 150, 150, false)

        val model = PneumoniaDetection.newInstance(mContext)

        val inputFeature0 =
            TensorBuffer.createFixedSize(intArrayOf(1, 150, 150, 3), DataType.FLOAT32)

        val byteBuffer = ByteBuffer.allocateDirect(4 * 150 * 150 * 3)
        byteBuffer.order(ByteOrder.nativeOrder())

        val intArray = IntArray(150 * 150)
        shapedBitmap.getPixels(intArray, 0, 150, 0, 0, 150, 150)

        var pixel = 0
        for (i in 0 until 150) {
            for (j in 0 until 150) {
                val p = intArray[pixel++]
                byteBuffer.putFloat((p shr 16 and 0xFF) * (1f / 255f))
                byteBuffer.putFloat((p shr 8 and 0xFF) * (1f / 255f))
                byteBuffer.putFloat((p and 0xFF) * (1f / 255f))
            }
        }

        inputFeature0.loadBuffer(byteBuffer)

        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer
        val confidences = outputFeature0.floatArray

        model.close()

        FinalResult.resultProbability=confidences[0]
        if (FinalResult.resultProbability<0.25)

        {
            FinalResult.resultName="Normal"
        }
        else
        {
            FinalResult.resultName="Pneumonic"
        }
        return FinalResult

    }

    companion object {
        const val TAG = "AnalyzerTag"
    }
}