import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class City {

	public String cityName;

	public City(String cityName) {
		super();
		this.cityName = cityName;
	}
	
	public static int count =3;

	public static void main(String args[]) {
		Person a = new Person("A","aaa",new City("SVG"));
		Person b = new Person("B","bbbb",new City("MDU"));
		Person c = new Person("C","ccc",new City("TPT"));
		Person d = new Person("D","ddd",new City("SVG"));
		Person e = new Person("E","eee",new City("MDU"));
		Person f = new Person("F","ffff",new City("DND"));
		Person g = new Person("G","gggg",new City("SVG"));
		
		List<Person> p = new ArrayList<>();
		p.add(a);
		p.add(b);
		p.add(c);
		p.add(d);
		p.add(e);
		p.add(f);
		p.add(g);
		
		
		
		//p.stream().collect(groupingBy(Person::getCity, mapping(Person::getLastName,toSet())));
		
		Map<String, Set<String>> namesByCity = p.stream().collect(Collectors.groupingBy(Person::getCity1,
                                              Collectors.mapping(Person::getLastName, Collectors.toSet())));
		
		Map<String, Long> countByCity = p.stream().collect(Collectors.groupingBy(Person::getCity1,LinkedHashMap::new, Collectors.counting()));
		
		Map<String, Set<String>> namesByCity1 = p.stream().filter(p1 -> p1.lastName.length() > count ).collect(Collectors.groupingBy(Person::getCity1,
                Collectors.mapping(Person::getLastName, Collectors.toSet())));
		

		for(Map.Entry<String, Long> s: countByCity.entrySet()){
			System.out.println("Key "+s.getKey());
			System.out.println("Key "+s.getValue());
		}
		
		for(Map.Entry<String, Set<String>> s: namesByCity.entrySet()){
			System.out.println("Key "+s.getKey());
			System.out.println("Key "+s.getValue());
		}
	}
}
