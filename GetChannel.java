package Frombook.IO;

import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class GetChannel {

	private static final int BSIZE = 1024;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		FileChannel in = new RandomAccessFile("C:\\Users\\HP\\Desktop\\java1.txt", "rw").getChannel();

		in.write(ByteBuffer.wrap("Some".getBytes()));

		in.position(in.size());
		in.write(ByteBuffer.wrap("Hello".getBytes()));
		in.close();

		FileChannel out = new FileInputStream("C:\\Users\\HP\\Desktop\\java1.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		out.read(buff);
		buff.flip();
		while(buff.hasRemaining()) {
			System.out.print((char)buff.get());
		}



	}
}
