package project;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Aplication {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter department´s name : ");
		String departmentName = teclado.nextLine();
		System.out.println("Enter worker data : ");
		
		System.out.println("Name : ");
		String workerName = teclado.nextLine();
		System.out.println("Level : ");
		String workerLevel = teclado.nextLine();
		System.out.println("Base Salary : ");
		double baseSalary = teclado.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary	, new Department(departmentName));
		
		
		System.out.println("How many contracts to this worker ?");
		int n = teclado.nextInt();
		
		for(int i=1 ;i<=n;i++) {
			System.out.println("Enter contract #" + i + "data");
			System.out.println("Date(DD/MM/YYYY):");
			Date contractDate = sdf.parse(teclado.next());
			System.out.println("Value per hour");
			double valuePerHour = teclado.nextDouble();
			System.out.print("Duration(hours):");
			int hours = teclado.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.println("Enter with month and year to calculate (MM/yyyy)");
		String monthAndYear = teclado.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: "+ worker.getDepartment().getName());
		System.out.println("Income for : " + monthAndYear + ":" + String.format("%.2f", worker.income(year, month)));
		
		
		
		
		
		teclado.close();
	}
	
	

}
