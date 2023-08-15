import org.opencv.core.Core
import org.opencv.core.Mat
import org.opencv.core.MatOfRect
import org.opencv.core.Scalar
import org.opencv.imgcodecs.Imgcodecs
import org.opencv.imgproc.Imgproc
import org.opencv.objdetect.CascadeClassifier

object FaceDetectionExample {
    @JvmStatic
    fun main(args: Array<String>) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME)

        // 加载人脸识别器
        val faceCascade = CascadeClassifier("haarcascade_frontalface_default.xml") // 请提供正确的文件路径

        // 读取图像
        val image: Mat = Imgcodecs.imread("image.jpg") // 请提供正确的图像路径

        // 转换为灰度图像
        val grayImage = Mat()
        Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_BGR2GRAY)

        // 运行人脸识别
        val faces = MatOfRect()
        faceCascade.detectMultiScale(grayImage, faces)

        // 标记人脸并显示图像
        for (rect in faces.toArray()) {
            Imgproc.rectangle(image, rect.tl(), rect.br(), Scalar(0.0, 255.0, 0.0), 2)
        }

        // 保存标记后的图像
        Imgcodecs.imwrite("output_image.jpg", image)
    }
}
