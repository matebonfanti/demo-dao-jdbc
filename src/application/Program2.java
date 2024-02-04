package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao =  DaoFactory.createDepartmentDao();
		
		System.out.println("==== TEST 1: Department Insert =====");
		Department newDepartment = new Department(null, "Roupas");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! new id = " + newDepartment.getId());
		
		
		System.out.println("==== TEST 2: Department Update =====");
		Department department = departmentDao.findById(1);
		department.setName("Comida");
		departmentDao.update(department);
		System.out.println("Updated Completed!");
		
		System.out.println("==== TEST 3: Department Delete =====");
		System.out.print("Inter id for delete test:  ");
		int id = sc.nextInt();		
		departmentDao.deleteById(id);
		System.out.println("Delete Complete");
		
		System.out.println("==== TEST 4: Find By Id =====");
		System.out.print("Inter id for find test:  ");
		 id = sc.nextInt();		
		Department dep = departmentDao.findById(id);
		System.out.println(dep);
		
		System.out.println("==== TEST 4: Find All =====");
		
		List<Department> depLst = departmentDao.findAll();
		
		for(Department e : depLst) {
			System.out.println(e);
		}
		
		
		sc.close();
	}

}
