package com.gmail.theslavahero;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task2NewThreadCopy extends Thread {

	private FileInputStream fis;
	private FileOutputStream fos;

	public Task2NewThreadCopy(FileInputStream fis, FileOutputStream fos) {
		super();
		this.fis = fis;
		this.fos = fos;
	}

	public FileInputStream getFis() {
		return fis;
	}

	public void setFis(FileInputStream fis) {
		this.fis = fis;
	}

	public FileOutputStream getFos() {
		return fos;
	}

	public void setFos(FileOutputStream fos) {
		this.fos = fos;
	}

	public void run() {

		try {
			byte[] buffer = new byte[1000];
			int byteRead = 0;

			for (; (byteRead = fis.read(buffer)) > 0;) {
				fos.write(buffer, 0, byteRead);
			}
			fis.close();
			fos.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public String toString() {
		return "Task2NewThreadCopy [fis=" + fis + ", fos=" + fos + "]";
	}

}
