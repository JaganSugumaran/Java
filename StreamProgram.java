import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamProgram {
	public static void main(String args[]) {
        List<Integer> myList =  Arrays.asList(10,15,8,49,125,98,32);
        Double l = myList.stream().filter(n -> n%2 == 0).collect(Collectors.averagingInt(n -> n));
        List<String> r = myList.stream().map(s-> s+"").filter(s -> s.startsWith("1")).collect(Collectors.toList());
        for(String str : r)
        System.out.println("From "+str);
        
        
        String str = "adjhihfoo";
        char c = str.chars()
        .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
        .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
        .entrySet()
        .stream()
        .filter(m -> m.getValue() == 1L)
        .map(m -> m.getKey())
        .findFirst()
        .get();
        
        
        System.out.println("Character "+c);
        
        Map<Integer, Long> map = myList.stream().collect(Collectors.groupingBy(e -> e,Collectors.counting()));
        for(Map.Entry<Integer, Long> m1 : map.entrySet())
        	System.out.println("From Map"+m1.getKey() + " "+m1.getValue());
        
        String str1 = "sssssssss";
        boolean c1 = str1.chars()
        		.mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
        .entrySet()
        .stream()
        .filter(entry -> entry.getValue() > 1L)
        .map(entry -> entry.getKey())
        .allMatch(s -> s == 'y');
        //.get();
        
        System.out.println("FRom Repeated Values "+c1);
        
        
        
        List<Integer> sortedArray = myList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        for(Integer i : sortedArray) {
        	System.out.println(i);
        }
        
        
        
        Map<String, List<String>> people = new HashMap<>();                                                                 
        people.put("Cena", Arrays.asList("123-1123", "456-3389"));                                                          
        people.put("Undertaker", Arrays.asList("678-2243", "986-5264"));                                                    
        people.put("Khali", Arrays.asList("678-6654", "986-3242"));
        
        people.values().stream().map(s->s).collect(Collectors.toList());
        people.values().stream().flatMap(Collection::stream);
        
        
        int max2 = Arrays.stream(new int[] {}).max().orElse(0);
        System.out.println(max2);
        final List<Integer> myList3 =  Arrays.asList(10,15,8,49,125,98,32);
        //myList3.add(34);
        System.out.println("MAX ======"+myList3.stream().max(Collections.reverseOrder()).get());
        String strstr = "Jagannn";
        String strstr1 = null;
        strstr1.equals("sdf");
        
        Map<Object, Object> countMap = strstr.chars()
		.mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
        .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
.entrySet()
.stream()
.filter(entry -> entry.getValue() > 1L)
.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));

        for(Map.Entry<Object, Object> m1 : countMap.entrySet())
        	System.out.println("From Map ============"+m1.getKey() + " "+m1.getValue());

        int a = 10;
        int b = 100;
        
        Integer ab = IntStream.rangeClosed(2, 5).sum();
        System.out.println("From INT STREAM ======"+ab);
        
        
	}
}
