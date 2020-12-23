package com.gmail.theslavahero;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task2Main {

	public static void main(String[] args) {

		File video = new File("C:\\Users\\slava\\eclipse-workspace\\Mnohopotok2\\from\\video.mp4");
		File videoCopy = new File("C:\\Users\\slava\\eclipse-workspace\\Mnohopotok2\\to\\video.mp4");
		try {
			FileInputStream fis = new FileInputStream(video);
			FileOutputStream fos = new FileOutputStream(videoCopy);
			Task2NewThreadCopy copy1 = new Task2NewThreadCopy(fis, fos);
			Task2NewThreadCopy copy2 = new Task2NewThreadCopy(fis, fos);
			long start = System.currentTimeMillis();
			copy1.start();
			copy2.start();
			copy1.join();
			copy2.join();
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
