package ru.mail.dimapilot;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Write {

	protected void write(String pathname, String data, String from, String to, String text) {

		try {

			File f = new File(pathname);
			RandomAccessFile raf = new RandomAccessFile(f, "rw");

			// Append data
			raf.seek(f.length()-2);

			raf.writeUTF("  Data:" + data + ",  From:" + from + ",  To:" + to + ",  Text:" + text + "          ';");

			raf.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
