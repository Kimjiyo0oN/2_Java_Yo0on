package edu.kh.employee.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.employee.vo.Employee;

//private int empId; // 사원 번호(사번)
//private String empName; // 사원 이름
//private String empNo; // 주민등록번호
//private String email; // 이메일
//private String phone; // 전화번호
//private String departmentTitle; // 부서명
//private String jobName; // 직급명
//private int salary; // 급여
public class EmployeeService {
	
	private Employee emp = new Employee();
	private Map<Integer, Employee> EmployeeMap = new HashMap<Integer, Employee>();
	
	public EmployeeService() {
		EmployeeMap.put(20142410, new Employee(20142410,"김지윤", "9500002000000","wlsss0000@naver.com","01040000000","KH","학생", 800000));
		EmployeeMap.put(20142045, new Employee(20142045,"이치윤", "9505151000000","cldbs8754@naver.com","01089584125","KH","학생", 800000));
		EmployeeMap.put(20091454, new Employee(20091454,"최시윤", "9010201000000","tldbs4536@naver.com","01089412578","KH","학생", 800000));
		EmployeeMap.put(20091455, new Employee(20091455,"김가람", "9312022000000","fndk4336@naver.com","01012415874","인사","사원", 1200000));
		EmployeeMap.put(20091456, new Employee(20091456,"최시원", "9202201000000","tsdfs4536@naver.com","01012345678","인사","팀장",2900000));
		EmployeeMap.put(20091457, new Employee(20091457,"정희도", "9711021000000","ututy4567@naver.com","01025896321","인사","대리",9500000));
	}
	
	/**새로운 직업 정보 추가
	 * @param empId
	 * @param empName
	 * @param departmentTitle
	 * @param jobName
	 * @param email
	 * @param empNo
	 * @param phone
	 * @param salary
	 * @return
	 */
	public String addEmployee(int empId, String empName, String departmentTitle,  String jobName,  String email, String empNo,  String phone, int salary) {
		String str = "";
		for(Integer key : EmployeeMap.keySet()){
			if(key == empId) {
				str = "일치하는 사번이 있습니다. 다른 사번을 입력해주세요.";
				return str;
			}	
		}
		EmployeeMap.put( Integer.valueOf(empId) , new Employee(empId ,empName, empNo,email,phone, departmentTitle,jobName, salary));
		str = "새로운 사원 정보 추가되었습니다.";
		return str;
	}
	
	/** 전체 직원 정보 조회
	 * @return
	 */
	public List<Employee> employeeview() {
		List<Employee> empList = new ArrayList<Employee>();
		for(Integer key : EmployeeMap.keySet()){
			empList.add(EmployeeMap.get(key));
		}
		return empList;
	}
	
	/** 직원 사번으로 직원 정보 조회
	 * @param empIp
	 * @return
	 */
	public Employee selectEmployee(int empIp) {
		return EmployeeMap.get(empIp); 
	}
	
	/** 사번으로 일치하는 사원 찾아 수정 
	 * @param empId
	 * @param departmentTitle
	 * @param jobName
	 * @param email
	 * @param phone
	 * @param salary
	 * @return
	 */
	public String selectUpdateEmployee(int empId, String departmentTitle,  String jobName,  String email,  String phone, int salary) {
		String str = "";
		for(Integer key : EmployeeMap.keySet()){
			if(key == empId) {
				EmployeeMap.replace(empId, new Employee( empId,EmployeeMap.get(empId).getEmpName() ,EmployeeMap.get(empId).getEmpNo(),  email, phone, departmentTitle, jobName, salary));
				str = "사번이 일치하는 사원 정보 수정 완료";
				return str;
			}	
		}
		str = "일치하는 사번이 없습니다.";
		return str;	
	}
	public String selectDelectEmployee(int empId) {
		String str = "";
		for(Integer key : EmployeeMap.keySet()){
			if(key == empId) {
				EmployeeMap.remove(key);
				str = "사번이 일치하는 사원 정보 삭제 완료";
				return str;
			}
		}
		str = "일치하는 사번이 없습니다.";
		return str;	
	}
	public List<Employee> selectDepTitleEmployee(String departmentTitle) {
		List<Employee> empList = new ArrayList<Employee>();
		for(Integer key : EmployeeMap.keySet()){
			if(EmployeeMap.get(key).getDepartmentTitle().equals(departmentTitle.toUpperCase())) {
				empList.add(EmployeeMap.get(key));
			}
		}
		return empList;
	}
	public List<Employee> selectSalaryEmployee(int salary) {
		List<Employee> empList = new ArrayList<Employee>();
		for(Integer key : EmployeeMap.keySet()){
			if(EmployeeMap.get(key).getSalary() >= salary) {
				empList.add(EmployeeMap.get(key));
			}
		}
		return empList;
	}
	public Map<String, Integer> selectdepTitleSalarySum() {
		Map<String, Integer> SalaryMap = new HashMap<String, Integer>();
		for(Integer key : EmployeeMap.keySet()){
			//EmployeeMap.get(key).getSalary()
			SalaryMap.put(EmployeeMap.get(key).getDepartmentTitle(),  SalaryMap.getOrDefault(EmployeeMap.get(key).getDepartmentTitle(), 0)+ EmployeeMap.get(key).getSalary());
		}
		return SalaryMap;
	}
}
