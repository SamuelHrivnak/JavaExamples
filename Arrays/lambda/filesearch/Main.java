package lambda.filesearch;

import java.util.Date;

public class Main {
	private static final String PATH = "c:\\Users\\jaros\\workspace\\JavaAcademyNess2018";

	public static void main(String[] args) {
		FileSearchUtil fsu = new FileSearchUtil();
		//String[] files = fsu.findAllFiles(PATH); 
		//String[] files = fsu.findAllDirectories(PATH); 
		//String[] files = fsu.findAllFilesAndDirectories(PATH);
		//String[] files = fsu.findFilesByPattern(PATH, ".*[.]java");
		//String[] files = fsu.findFilesByPattern(PATH, ".*[.]java");
		
		String[] files = fsu.findFilesByLastChange(PATH, new Date(System.currentTimeMillis() - 60000));
		
		for(String file : files)
			System.out.println(file);
	}
}
