package com.example.demo.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.vo.Employee;

public class EmployeeMain {

	public static void main(String[] args) {

		List<Employee> employeeList = getListEmployeeObject();

		Comparator<Employee> compareList = Comparator.comparing(Employee::getAge).thenComparing(Employee::getName);

		List<Employee> sortedEmployees = employeeList.stream().sorted(compareList).collect(Collectors.toList());

		sortedEmployees.forEach((e) -> System.out.println(e.getName()));
		System.out.println();
		List<String> empName = sortedEmployees.stream().filter(e -> e.getAge() >= 10).map(Employee::getName)
				.collect(Collectors.toList());

		empName.forEach((e) -> System.out.println(e));
	}

	private static List<Employee> getListEmployeeObject() {
		List<Employee> listEmp = new ArrayList<>();

		Employee employeeObj = new Employee();
		employeeObj.setName("Suresh");
		employeeObj.setAge(13);

		Employee employeeObj1 = new Employee();
		employeeObj1.setName("Ramesh");
		employeeObj1.setAge(11);

		Employee employeeObj2 = new Employee();
		employeeObj2.setName("Kishore");
		employeeObj2.setAge(5);

		Employee employeeObj3 = new Employee();
		employeeObj3.setName("SaiRam");
		employeeObj3.setAge(25);

		listEmp.add(employeeObj);
		listEmp.add(employeeObj1);
		listEmp.add(employeeObj2);
		listEmp.add(employeeObj3);

		return listEmp;
	}
}

