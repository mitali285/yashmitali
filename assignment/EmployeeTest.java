package assignment;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee employee1 = new Employee("Yash", 23, new Address("1234"),
				Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

		Employee employee2 = new Employee("Ram", 24, new Address("1235"),
				Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

		Employee employee3 = new Employee("Sita", 20, new Address("1236"),
				Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

		List<Employee> employees = Arrays.asList(employee1, employee2, employee3);

		// Get employee with exact match name "Yash", if not found print "Not
		// found".
		Employee emp = employees.stream().filter(e -> "Yash".equals(e.getName())).findAny().orElse(null);
		//System.out.println(emp);
         if(emp==null)
         {
        	 System.out.println("not found");
         }
         else
         {
         System.out.println(emp);
         }
		// Get employee with matching address "1235"
		Employee emp1 = employees.stream().filter(e -> "1235".equals(e.getAddress().getZipcode())).findAny()
				.orElse(null);
		System.out.println(emp1);

		// Get all employee having mobile numbers 3333.
		
		List<Employee> resultEmployees = employees.stream()
            .filter(e -> emp.getMobileNumbers().stream().anyMatch(mob->mob.getNumber().equals("3333")))
             .collect(Collectors.toList());
   resultEmployees.forEach(System.out::println);

		// Convert List<Employee> to List<String> of employee name
		List<String> empList1 = employees.stream().map(e -> e.getName()).collect(Collectors.toList());
		empList1.forEach(System.out::println);

		// Collect all the names of employees in a string separated by ||
		String empInStringFormat = employees.stream().map(e -> e.getName()).collect(Collectors.joining("||"));
		System.out.println(empInStringFormat);

		// Change the case of List<String>
		List<String> lst = empList1.stream().map(name -> name.toUpperCase()).collect(Collectors.toList());
		// List<String> lst=empList1.stream().map(name ->
		// name.toUpperCase()).forEach(name -> System.out.print(name + " "));
		lst.forEach(System.out::println);

		// Sort List<String>
		List<String> sortedList = empList1.stream().sorted().collect(Collectors.toList());
		System.out.println("lst" + sortedList);

		// sort List<Employee> based on name
		Comparator<Employee> c2 = Comparator.comparing(Employee::getName);
		Collections.sort(employees, c2);
		System.out.println("Sorted List by name : " + employees);
		// for (Employee e5 : employees) {
		// System.out.println(e5);
		//
		// // Collections.sort(emp);
		//
		// }

		Comparator<Employee> c4 = Comparator.comparing(Employee::getAge);
		Collections.sort(employees, c4);
		System.out.println("Sorted List by age: " + employees);
		List<Employee> sortedByAge = employees.stream().sorted(c4).collect(Collectors.toList());
		System.out.println("Sorted List by age from sortedBy(): " + sortedByAge);

		List<Employee> sortedByName = employees.stream().sorted((e1, e2) -> -e1.getName().compareTo(e2.getName()))
				.collect(Collectors.toList());
		System.out.println("Sorted List by name from sortedBy(): " + sortedByName);

	}
}
