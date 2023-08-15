package com.ori;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class FaceDetectionExample {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // 加载人脸识别器
        CascadeClassifier faceCascade = new CascadeClassifier("haarcascade_frontalface_default.xml");  // 请提供正确的文件路径

        // 读取图像
        Mat image = Imgcodecs.imread("image.jpg");  // 请提供正确的图像路径

        // 转换为灰度图像
        Mat grayImage = new Mat();
        Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_BGR2GRAY);

        // 运行人脸识别
        MatOfRect faces = new MatOfRect();
        faceCascade.detectMultiScale(grayImage, faces);

        // 标记人脸并显示图像
        for (Rect rect : faces.toArray()) {
            Imgproc.rectangle(image, rect.tl(), rect.br(), new Scalar(0, 255, 0), 2);
        }

        // 保存标记后的图像
        Imgcodecs.imwrite("output_image.jpg", image);
    }
}
