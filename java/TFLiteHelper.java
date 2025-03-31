package com.example.cropguard;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.Interpreter;
import org.tensorflow.lite.support.common.ops.NormalizeOp;
import org.tensorflow.lite.support.image.ImageProcessor;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.image.ops.ResizeOp;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class TFLiteHelper {

    private Interpreter tflite;
    private Context context;

    public TFLiteHelper(Context context) {
        this.context = context;
    }

    public void loadModel(String modelFileName) throws IOException {
        ByteBuffer tfliteModel = loadModelFile(modelFileName);
        tflite = new Interpreter(tfliteModel);
    }

    private MappedByteBuffer loadModelFile(String modelFileName) throws IOException {
        AssetFileDescriptor fileDescriptor = context.getAssets().openFd(modelFileName);
        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }

    public String classify(Bitmap bitmap) {
        TensorImage inputImage = TensorImage.fromBitmap(bitmap);

        ImageProcessor imageProcessor = new ImageProcessor.Builder()
                .add(new ResizeOp(224, 224, ResizeOp.ResizeMethod.BILINEAR)) // Adjust size if needed
                .add(new NormalizeOp(0, 255))
                .build();
        TensorImage processedImage = imageProcessor.process(inputImage);

        TensorBuffer outputBuffer = TensorBuffer.createFixedSize(new int[]{1, 1024}, DataType.UINT8); // Adjust data type and size

        tflite.run(processedImage.getBuffer(), outputBuffer.getBuffer().rewind());

        String jsonOutput = "";
        try {
            jsonOutput = new String(outputBuffer.getBuffer().array(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error reading model output."; // Handle error as needed
        }

        return jsonOutput;
    }

    public Interpreter getInterpreter() {
        return tflite;
    }

    public void close() {
        if (tflite != null) {
            tflite.close();
        }
    }
}