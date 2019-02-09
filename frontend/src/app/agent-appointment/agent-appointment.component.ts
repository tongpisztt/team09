import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../service/appointment.service';
import { HttpClient } from '@angular/common/http';
import { Router} from '@angular/router';

@Component({
selector: 'app-agent-appointment',
templateUrl: './agent-appointment.component.html',
styleUrls: ['./agent-appointment.component.css']
})
export class AgentAppointmentComponent implements OnInit {
Categories : Array<any>;
Genders: Array<any>;
Date : Array<any>;
Duration : Array<any>;
Provinces : Array<any>;
Appointment : any = {
typeName: '', fName: '', lName: '', idCardNum: '' ,genderName: '', age: '', telNum: ''
,email: '' , provinceName: '', date: '',  duration: ''};

constructor(private appointService : AppointmentService ,private httpClient: HttpClient, private router:Router) { }
  ngOnInit() {
    this.appointService.getAppointment().subscribe(data => { this.Appointment = data; console.log(this.Appointment);});
    this.appointService.getCategory().subscribe(dataF => { this.Categories = dataF; console.log(this.Categories);});
    this.appointService.getGender().subscribe(dataB => { this.Genders = dataB; console.log(this.Genders);});
    this.appointService.getDateAppointment().subscribe(dataC => { this.Date = dataC; console.log(this.Date);});
    this.appointService.getDurationAppointment().subscribe(dataD => { this.Duration = dataD; console.log(this.Duration);});
    this.appointService.getProvince().subscribe(dataE => { this.Provinces = dataE; console.log(this.Provinces);});   }

   save() {
      if(this.Appointment.typeName == null){alert('กรุณาเลือกประเภทประกันที่สนใจ');}
      if(this.Appointment.fName == null){alert('กรุณากรอกชื่อจริง');}
      if(this.Appointment.lName == null){alert('กรุณากรอกนามสกุล');}
      if(this.Appointment.idCardNum == null){alert('กรุณากรอกรหัสบัตรประชาชน');}
      if(this.Appointment.genderName == null){alert('กรุณาเลือกเพศ');}
      if(this.Appointment.age == null){alert('กรุณากรอกอายุ');}
      if(this.Appointment.telNum == null){alert('กรุณากรอกเบอร์โทรศัทพ์');}
      if(this.Appointment.email == null){alert('กรุณากรอก email');}
      if(this.Appointment.provinceName == null){alert('กรุณาเลือกจังหวัดที่ต้องการ');}
      if(this.Appointment.date == null){alert('กรุณาเลือกวันที่ต้องการ');}
      if(this.Appointment.duration == null){alert('กรุณาเลือกเวลาที่ต้องการ');}

      else{
        this.httpClient.post('http://localhost:8080/MakeAppointment/' + this.Appointment.typeName + '/'
        + this.Appointment.fName + '/' + this.Appointment.lName + '/' + this.Appointment.idCardNum + '/'
        + this.Appointment.genderName + '/' + this.Appointment.age + '/' + this.Appointment.telNum + '/'
        + this.Appointment.email + '/' + this.Appointment.provinceName + '/'+ this.Appointment.date + '/'
        + this.Appointment.duration
        ,this.Appointment)
          .subscribe(
             data => {

             console.log(this.Appointment)
              const Appointment  = this.Appointment
              this.router.navigate(['showAppointmentResult',{ typeName:Appointment.typeName, fName:Appointment.fName
              , lName:Appointment.lName , idCardNum:Appointment.idCardNum , genderName :this.Appointment.genderName
              , age:Appointment.age , telNum:Appointment.telNum, email:Appointment.email, provinceName:Appointment.provinceName
              , date:Appointment.date, duration:Appointment.duration}])
              console.log('PUT Request is successful', data);
              {alert('ลงทะเบียนสำเร็จ!');}

             },
             error => { console.log('Rrror', error); }
          );

        }
    }
}
