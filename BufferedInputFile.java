package Frombook.IO;

import java.io.*;


public class BufferedInputFile {
	public static String read (String path) throws IOException {
		BufferedReader bReader  = new BufferedReader(new FileReader(path));
		String s;
		StringBuilder sb = new StringBuilder();
		while ((s = bReader.readLine()) != null) {
			sb.append(s + "\n");
			
			
		}
		bReader.close();
		return(sb.toString());
		
	} 

}
