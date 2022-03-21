package Frombook.IO;

import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.io.*;

public class BufferToText {
	private static final int BSIZE = 1024;

	public static void main(String[] args) throws IOException {

		FileChannel fc = new FileOutputStream("C:\\Users\\HP\\Desktop\\java1.txt").getChannel();
		fc.write((ByteBuffer.wrap("Some text".getBytes())));
		fc.close();
		fc = new FileInputStream("C:\\Users\\HP\\Desktop\\java1.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();
		// Не работает:
		System.out.println(buff.asCharBuffer());
		// Декодировать с использованием кодировки по умолчанию:
		buff.rewind();
		
		
		
		String encoding = System.getProperty("file.encoding");
		System.out.println("Decoded using " + encoding + ":" + Charset.forName(encoding).decode(buff));
		// А можно использовать кодировку, пригодную для печати:
		fc = new FileOutputStream("C:\\Users\\HP\\Desktop\\java1.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
		fc.close();
		// Снова пьггаемся прочитать:
		fc = new FileInputStream("C:\\Users\\HP\\Desktop\\java1.txt").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		// Используем CharBuffer для записи:
		fc = new FileOutputStream("C:\\Users\\HP\\Desktop\\java1.txt").getChannel();
		buff = ByteBuffer.allocate(24); // More than needed
		
		buff.asCharBuffer().put("HEllO");
		System.out.println("=============");
	
		System.out.println("=============");
		
		fc.write(buff);
		
		
	
		fc.close();
		// Чтение и отображение:
		fc = new FileInputStream("C:\\Users\\HP\\Desktop\\java1.txt").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		while (buff.getClass().equals(Character.class))
			System.out.println((char)buff.get());
		
		
	}
	public void put(String s) {
		
		
	}
}
