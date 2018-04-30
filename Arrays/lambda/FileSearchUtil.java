package lambda;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FileSearchUtil {
	List<String> array = new ArrayList<>();

	public static void main(String[] args) {
		File file = new File("C:\\Users/P3502855/eclipse-workspace/.metadata/.mylyn");
		System.out.println(file.isDirectory());
		// List<String> array = new ArrayList<>();
		FileSearchUtil fSearchUtil = new FileSearchUtil();
		System.out.println(fSearchUtil.findAllFiles(file));
		fSearchUtil.resetArray();
		System.out.println(fSearchUtil.findAllDirectories(file));
		fSearchUtil.resetArray();
		System.out.println(fSearchUtil.findAllFilesAndDirectories(file));

	}

	
	
	
	
	

	public List<String> findAllFiles(File dir) {
		if (dir.isFile()) {
			array.add(dir.toString());
			return array;
		}

		for (File file : dir.listFiles())
			findAllFiles(file);
		return array;
	}

	public List<String> findAllDirectories(File dir) {
		if (dir.isDirectory()) {
			array.add(dir.toString());
		}else return array;

		if (dir != null) {
			for (File file : dir.listFiles()) {
				findAllDirectories(file);
			}
		}
		return array;
	}

	public List<String> findAllFilesAndDirectories(File root)
	{
	    File[] files = root.listFiles(); 
	    for (File file : files) {
	        if (file.isFile()) {
	            array.add(file.toString());
	        } else if (file.isDirectory()) {
	        	array.add(file.toString());
	            findAllFilesAndDirectories(file);
	        }else return array;
	    }
		return array;
	}
	
	
	
	public void resetArray() {
		array = new ArrayList<>();
	}

}
