package lambda.filesearch;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class FileSearchUtil {

	public String[] findAllFiles(String path) {
		return find(path, f -> f.isFile());
	}

	public String[] findAllDirectories(String path) {
		return find(path, f -> f.isDirectory());
	}

	public String[] findAllFilesAndDirectories(String path) {
		return find(path, f -> true);
	}

	public String[] findFilesByPattern(String path, String pattern) {
		return find(path, f -> f.getName().matches(pattern));
	}

	public String[] findFilesByLastChange(String path, Date date) {
		return find(path, f -> f.lastModified() >= date.getTime());
	}
	public String[] findAllHiddenFiles(String path, Date date) {
		return find(path, f -> f.isHidden());
	}
	

	private String[] find(String path, Predicate<File> filter) {
		File dir = validatePath(path);
		List<String> files = new ArrayList<>();
		find(files, dir, filter);
		return files.toArray(new String[] {});
	}

	private File validatePath(String path) {
		File dir = new File(path);
		if(!dir.exists())
			throw new FileSearchUtilException("Not valid path " + path);
		return dir;
	}

	private void find(List<String> files, File dir, Predicate<File> filter) {
		for(File file : dir.listFiles()) {
			if(filter.test(file))
				files.add(file.getAbsolutePath());
			if(file.isDirectory())
				find(files, file, filter);
		}
	}
}
