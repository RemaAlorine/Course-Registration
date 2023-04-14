<h1 align="center"> Course-Registration System<h1>
<h3 align="center">simple course registration system that tracks and facilitates the process of course registering for trainees <h3>
<h4 align="left">Functionalities: <h4>
<h5 align="left">- adding a new course <h5>
<h5 align="left">- Register a course for a trainee <h5>
<h5 align="left">- Cancel Course Registration <h5>
<h5 align="left">- Find and Display the information of a course <h5>
<h5 align="left">- List All courses <h5>
<h5 align="left">- Find and Display list of registered courses for a given trainee<h5>
<h5 align="left">- Compute and Display the total tuition for a given trainee<h5>
<h5 align="left">- Display total number of added courses <h5>
<br><br>

<h3 align="left">Classes:<h3>
<h4 align="left">Course: A course class is identified by:<h4>
<h5 align="left">
-courseCode: String of wo letters followed by two digits. <br>
-weeklyTimeSlots: is a String of format: “DDD-S-E”, where D is an integer represent the 
days number (1 to 5),ex: (135 means Sunday, Tuesday and Thursday), S is a digit 
represents the session starting hour. E is a digit represents the session end hour.
<br>
-finalExamDate: is a String in the format (DD/MM/YY)
<br>
-tuition: the charge of the course
<br>
-traineeNames: list of trainee names register the course.
<br>
-totalCourses: the total number of registered courses
<h5>

<h4 align="left">The methods included in the class are <h4>
<h5 align="left">
Course(): 
<br>
A constructor that initializes all instance variables of the class:
<br>
- numeric data types are initialized to zero. Strings are initialized to null string (“”)
<br>
Course(String theCourseCode, String CTimeSlots, String CFinalExamDate, 
double CTuition):
<br>
Another constructor that initializes new course with the initial values 
from the user.
<br>
Setter methods (one for each):
<br>
sets values entered by the user for traineeNames.
<br>
Getter methods (one for each):
<br>
That returns the values of: That sets values entered by the 
user for: CourseCode, tuition, weeklyTimeSlots, FinalExamDate, traineeNames.
<br>
DispalyCourseInfo():
<br>
this method should display the information of a course.
<h5>
