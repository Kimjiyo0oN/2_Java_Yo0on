package edu.kh.employee.view;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import edu.kh.employee.service.EmployeeService;
import edu.kh.employee.vo.Employee;

public class EmployeeView {
	//private Employee emp = new Employee();
	private Scanner sc = new Scanner(System.in);
	private EmployeeService service = new EmployeeService();
	public void display() {
		int input =0;
		do{
			System.out.println("\n1. 새로운 사원 정보 추가");
			System.out.println("2. 전체 사원 정보 조회");
			System.out.println("3. 사번이 일치하는 사원 정보 조회");
			System.out.println("4. 사번이 일치하는 사원 정보 수정");     
			System.out.println("5. 사번이 일치하는 사원 정보 삭제");           
			System.out.println("6. 입력 받은 부서와 일치 모든 사원 정보 조회");          //까지 완성
			System.out.println("7. 입력 받은 급여 이상을 받는 모든 사원 정보 조회");
			System.out.println("8. 부서별 급여 합 전체 조회");
			System.out.println("0. 프로그램 종료");
			try {
				System.out.print("메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();
				
				System.out.println();
				
				switch(input) {
				case 1: addEmployee(); break;
				case 2: selectAll(); break;
				case 3: selectEmployee(); break;
				case 4: selectUpdateEmployee(); break;
				case 5: selectDelectEmployee(); break;
				case 6: selectDepTitleEmployee(); break;
				case 7: selectSalaryEmployee(); break;
				case 8:selectdepTitleSalarySum();break;
				case 0:System.out.println("프로그램을 종료합니다. ");break;
				default: System.out.println("잘못입력하셨습니다. ");
				}
			} catch (InputMismatchException
					e) {
				e.printStackTrace();
				System.out.println("입력값이 잘못되었습니다.");
				input =-1;
				sc.nextLine();
			}
			
			
		}while(input !=0);
	}
//	private int empId; // 사원 번호(사번)
//	private String empName; // 사원 이름
//	private String empNo; // 주민등록번호
//	private String email; // 이메일
//	private String phone; // 전화번호
//	private String departmentTitle; // 부서명
//	private String jobName; // 직급명
//	private int salary; // 급여
	public void addEmployee() {
		String str ="";
		System.out.println("[새로운 사원 정보 추가]");
		
		System.out.print("사원 번호 : ");
		int empId = sc.nextInt();
		
		System.out.print("사원 이름 : ");
		String empName = sc.next();
		
		System.out.print("주민등록번호 : ");
		String empNo = sc.next();
		
		System.out.print("이메일 : ");
		String email = sc.next();
		
		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		System.out.print("부서명 : ");
		String departmentTitle = sc.next();
		
		System.out.print("직급명 : ");
		String jobName = sc.next();
		
		System.out.print("급여 : ");
		int salary = sc.nextInt();
		sc.nextLine();
		
		str = service.addEmployee(empId, empName, departmentTitle, jobName, email, empNo, phone, salary);
		
		System.out.println(str);
		
	}
	private void selectAll() {
		List<Employee> empList =service.employeeview();
		
		System.out.println("[전체 사원 정보 조회]");
	
		for(Employee e : empList) {
			System.out.println(e);
		}
		
	}
	public void selectEmployee() {
		
		System.out.println("[사번이 일치하는 사원 정보 조회]");
		
		System.out.print("사원 번호 : ");
		int empId = sc.nextInt();
		sc.nextLine();
		
		System.out.println(service.selectEmployee(empId));
		
	}
	public void selectUpdateEmployee() {
		
		System.out.println("[사번이 일치하는 사원 정보 수정]");
		
		System.out.print("사원 번호 : ");
		int empId = sc.nextInt();
		
		System.out.print("이메일 : ");
		String email = sc.next();
		
		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		System.out.print("부서명 : ");
		String departmentTitle = sc.next();
		
		System.out.print("직급명 : ");
		String jobName = sc.next();
		
		System.out.print("급여 : ");
		int salary = sc.nextInt();
		sc.nextLine();
		
		System.out.println(service.selectUpdateEmployee(empId, departmentTitle, jobName, email, phone, salary));
		
		//System.out.println(service.selectEmployee(empId));
		
	}
	public void selectDelectEmployee() {
		System.out.println("[사번이 일치하는 사원 정보 삭제]");
		
		System.out.print("사원 번호 : ");
		int empId = sc.nextInt();
		sc.nextLine();
		
		System.out.println(service.selectDelectEmployee(empId));
	}
	public void selectDepTitleEmployee() {
		System.out.println("[입력 받은 부서와 일치 모든 사원 정보 조회]");
		System.out.print("부서명 : ");
		String departmentTitle = sc.next();
		sc.nextLine();
		
		List<Employee> empList = service.selectDepTitleEmployee(departmentTitle);
		if(empList.isEmpty()) {
			System.out.println("일치하는 부서가 없습니다.");
		}else {
			for(Employee e : empList) {
				System.out.println(e);
			}
		}	
	}
	public void selectSalaryEmployee() {
		System.out.println("[입력 받은 급여 이상을 받는 모든 사원 정보 조회]");
		
		System.out.print("급여 : ");
		int salary = sc.nextInt();
		sc.nextLine();
		List<Employee> empList = service.selectSalaryEmployee(salary);
		if(empList.isEmpty()) {
			System.out.println("입력 받은 급여 이상 받는 사원이 조회되지 않습니다.");
		}else {
			for(Employee e : empList) {
				System.out.println(e);
			}
		}	
		
	}
	public void selectdepTitleSalarySum() {
		System.out.println("[부서별 급여 합 전체 조회]");
		Map<String, Integer> SalaryMap = service.selectdepTitleSalarySum();
		for(String key : SalaryMap.keySet()) System.out.println(key +" : "+SalaryMap.get(key));
	}
	
}
