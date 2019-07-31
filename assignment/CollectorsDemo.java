package assignment;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsDemo {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 20, 30, 11, 20, 33, 4, 44, 55, 20);

		// Displaying the elements
		numbers.forEach(s -> System.out.println(s));

		// System.out.println(even);
		numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

		// collect the result of a Stream into Set
		Set<Integer> result1 = numbers.stream().collect(Collectors.toSet());
		System.out.println(result1);

		// collect the result of a Stream into list
		List<Integer> result2 = numbers.stream().collect(Collectors.toList());
		System.out.println(result2);

		// create Map from the elements of Stream (first remove the duplicates)
		Map<Integer, String> intToString = result1.stream()
                .collect(Collectors.toMap(Function.identity(), 
                                             String::valueOf));
		System.out.println(intToString);
		
		
		// find summary statistics from a Stream of numbers
		IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(i -> i));
		System.out.println("Sum:" + stats.getSum());

		// partition the result of Stream in two parts i.e., odd and even
		Map<Boolean, List<Integer>> m = numbers.stream().collect(Collectors.partitioningBy(numbe -> numbe % 2 == 0));
		System.out.println(m.get(true));
		System.out.println(m.get(false));

		// create comma separated string from numbers
		String comma=numbers.stream().map(String::valueOf).collect(Collectors.joining(","));
		System.out.println(comma);
     
	}
}
