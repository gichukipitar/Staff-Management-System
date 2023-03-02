import axios from 'axios';
const EMPLOYEE_BASE_URL = "http://localhost:8080/employeemanagamentsystem/employee/listall"
class EmployeeService{
    getEmployees(){
        return axios.get(EMPLOYEE_BASE_URL);
    }


}
export default new EmployeeService()