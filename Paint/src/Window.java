import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Window extends Application {
	
	private ImageView video;
	private ImageView procVideo;
	private Timer timer;
	private TimerTask timerTask;
	
	public Window()
	{
		timer = new Timer(true);
	}
	
	public void run(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage mainStage) throws Exception
	{	
		mainStage.setTitle("Paint");
		mainStage.setWidth(800);
		mainStage.setHeight(600);
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
			
		Text videoLabel = new Text("Webcam");
		grid.add(videoLabel, 0, 0);
		
		Text procVideoLabel = new Text("Processed");
		grid.add(procVideoLabel, 1, 0);
		
		video = new ImageView();
		video.setFitHeight(250);
		video.setFitWidth(250);
		grid.add(video, 0, 1);
		
		procVideo = new ImageView();
		procVideo.setFitHeight(250);
		procVideo.setFitWidth(250);
		grid.add(procVideo, 1, 1);
		
		timerTask = new OCV(video, procVideo);
		
		Scene scene = new Scene(grid, 700, 500);
		mainStage.setScene(scene);
		mainStage.show();
		
		timer.scheduleAtFixedRate(timerTask, 1000, 33);
	}
	
	

}
