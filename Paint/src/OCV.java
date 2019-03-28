import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OCV extends TimerTask {

	private ImageView video;
	private ImageView procVideo;
	private VideoCapture webcam;
	
	public OCV(ImageView video, ImageView procVideo)
	{
		this.video = video;
		this.procVideo = procVideo;
		webcam = new VideoCapture(0);
	}
	
	public Image matToImage(Mat m) throws IOException
	{
		MatOfByte mob = new MatOfByte();
		Imgcodecs.imencode(".png", m, mob);
		byte[] ba = mob.toArray();
		ByteArrayInputStream stream = new ByteArrayInputStream(ba);
		return new Image(stream);
	}
	
	@Override
	public void run()
	{
		Mat vFrame = new Mat();
		webcam.read(vFrame);
		try {
			video.setImage(matToImage(vFrame));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
