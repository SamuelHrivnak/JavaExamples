package lambda;

import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import persons.Person;

public class Stream3 {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Janko", "31312"));

		System.out.println(Filter(persons, p -> p.getFirstName().length() > 4));
		System.out.println(persons.stream().filter(p -> p.getFirstName().length() > 4).collect(Collectors.toList()));
		System.out.println(persons.stream().filter(p -> p.getFirstName().length() > 4).count());
		System.out.println(persons.stream().mapToInt(p -> p.getFirstName().length()).sum());
	}
	public static <T> List<T> Filter(List<T> list, Predicate<T> predicate){
		List<T> result = new ArrayList<>();
		
		for (T t : list) 
			if (predicate.test(t)) 
				result.add(t);
			
			return result;
		
	}

}
