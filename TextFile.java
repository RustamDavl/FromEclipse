package Frombook.IO;

import java.io.*;
import java.util.*;

public class TextFile extends ArrayList<String> {

	public static String read(String fileName) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader in = new BufferedReader(new FileReader(new File(fileName)))) {

			String s;
			while ((s = in.readLine()) != null) {
				sb.append(s);
				sb.append("\n");
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return sb.toString();
	}

	// Запись файла одним вызовом метода:
	public static void write(String fileName, String text) {
		try (PrintWriter out = new PrintWriter(new File(fileName))) {

			out.print(text);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// Чтение файла с разбивкой по регулярному выражению:
	public TextFile(String fileName, String splitter) {
		super(Arrays.asList(read(fileName).split(splitter)));
		// Регулярное выражение split() часто оставляет
		// пустую строку в первой позиции:
		if (get(0).equals(""))
			remove(0);
	}

	// Обычное чтение по строкам:
	public TextFile(String fileName) {
		this(fileName, "\n");

	}

	public void write(String fileName)  {
		try (PrintWriter out = new PrintWriter(new File(fileName))) {

			for (String item : this)
				out.println(item);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
