import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  id:number;
  employee:Employee;

  constructor(
    private employeeService: EmployeeService,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      this.employee = data;
    }, error => console.error(error));
  }

}
