package ru.mail.dimapilot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.util.ArrayList;

public class Write {

	ArrayList<String> i = new ArrayList<String>();
	

	protected synchronized void adduser(String pathname, String user) {
		try {

			i.add(user);

			Writer writer = new FileWriter(pathname);
			writer.write("var status = '" + i.toString() + "';");
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected synchronized void deleteuser(String pathname, String user) {
		try {

			i.remove(user);

			Writer writer = new FileWriter(pathname);
			writer.write("var status = '" + i.toString() + "';");
			System.out.println(i.toString());
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void write(String pathname, String data, String from, String to, String text) {

		try {

			File f = new File(pathname);
			RandomAccessFile raf = new RandomAccessFile(f, "rw");

			// Append data
			raf.seek(f.length() - 2);

			raf.writeUTF("  Data:" + data + ",  From:" + from + ",  To:" + to + ",  Text:" + text + "          ';");

			raf.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
