package Frombook.IO;

import java.io.*;

public class Redirect {
	public static void main(String[] args) throws IOException {

		PrintStream console = System.out;
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("C:\\Users\\HP\\Desktop\\java.txt"));
		PrintStream out = new PrintStream(
				new BufferedOutputStream(new FileOutputStream("C:\\Users\\HP\\Desktop\\err.txt")));
		System.setOut(out);
		
		
		
		System.setIn(in);
		
		System.setErr(out);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = br.readLine()) != null )
			System.out.println(s);
		out.close(); // Не забудьте!
		System.setOut(console);
		
	}

}
