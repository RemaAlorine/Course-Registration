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
-courseCode: String of wo letters followed by two digits.
  <br>
  <p></p>
-weeklyTimeSlots: is a String of format: “DDD-S-E”, where D is an integer represent the 
days number (1 to 5),ex: (135 means Sunday, Tuesday and Thursday), S is a digit 
represents the session starting hour. E is a digit represents the session end hour.
<br>
   <p></p>
-finalExamDate: is a String in the format (DD/MM/YY)
<br>
   <p></p>
-tuition: the charge of the course
<br>
   <p></p>
-traineeNames: list of trainee names register the course.
<br>
   <p></p>
-totalCourses: the total number of registered courses
<h5>

<h4 align="left">The methods included in the class are: <h4>
<h5 align="left">
Course(): 
<br>
   <p></p>
A constructor that initializes all instance variables of the class:
<br>
   <p></p>
- numeric data types are initialized to zero. Strings are initialized to null string (“”)
<br>
   <p></p>
Course(String theCourseCode, String CTimeSlots, String CFinalExamDate, 
double CTuition):
<br>
   <p></p>
Another constructor that initializes new course with the initial values 
from the user.
<br>
   <p></p>
Setter methods (one for each):
<br>
   <p></p>
sets values entered by the user for traineeNames.
<br>
   <p></p>
Getter methods (one for each):
<br>
   <p></p>
That returns the values of: That sets values entered by the 
user for: CourseCode, tuition, weeklyTimeSlots, FinalExamDate, traineeNames.
<br>
   <p></p>
DispalyCourseInfo():
<br>
   <p></p>
this method should display the information of a course.
<h5>
  <br>
  <p></p>
   <p></p>
<h4 align="left">Institution: This class represents the institute offering courses. It contains a list of courses, 
courses[] of size 20. <h4>
  <h4 align="left">The methods included in the class are:<h4>
<h5 align="left">
  Add a new course: 
  <br>
  <p></p>
  This choice should enable the user to add a new course to the list of 
courses in courses[]. The method should return true if the course is added successfully or 
false otherwise. The course is added successfully if the course code is unique.
  <br>
  <p></p>
o Method name: addCourse
  <p></p>
o Method type: boolean
  <p></p>
o Formal parameters: courseCode, weeklyTimeSlots, finalExamDate, tuition)
  <p></p>
  <p></p>
  
  Register a course: 
  <br>
  <p></p>
  This choice enable the user to register a course for a trainee, given the 
trainee name and course code. The method should return true if the course is registered 
successfully or false otherwise. A Successful registration process should meets the three 
conditions: no conflicts in weekly sessions, no conflict in final exam date in the trainee 
schedule, and the course is available (has capacity).Remember that trainee schedule can
include at most 3 courses.
  <br>
  <p></p>
  
o Method name: registerCourse
  <p></p>
o Method type: boolean
  <p></p>
o Formal parameters: courseCode, traineeName
  <p></p>
  <p></p>
  
  
  
  
<h5>
  
  
