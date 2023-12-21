package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.Pice;

public class FileLoader {
	public static void ucitajFajlove() {
		try {
			Scanner sc = new Scanner(new File("pice.txt"));
			while(sc.hasNextLine()) {
				String[] s = sc.nextLine().split(",");
				Database.getInstance().getPica().add(new Pice(s[0], Double.parseDouble(s[1])));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
