package audio;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioMain {
	
public static void playL(String Path) throws LineUnavailableException, AWTException {
		
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(Path).getAbsoluteFile());
			Clip clip1 = AudioSystem.getClip();
			clip1.open(audioInputStream);
			clip1.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
	
}

}
