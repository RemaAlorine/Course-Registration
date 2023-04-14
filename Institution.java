import java.util.Scanner;
public class Institution {
private static Course[] courses = new Course[20];
static Scanner input = new Scanner (System.in);

public static void main (String[] args){

addCourse("IT01" , "135-11-12", "12/02/21" , 3000);
addCourse("CS01" , "135-8-9", "13/02/21" , 2000);
addCourse("IS01" , "135-9-10", "11/02/21" , 1000);
addCourse("SW01" , "234-8-9", "14/02/21" , 2000);
addCourse("IT20" , "135-12-01", "20/02/21" , 1000);
registerCourse("IT01","Ali");
registerCourse("IT01","Sara");
registerCourse("CS01","Sara");
registerCourse("IS01","Sara");
registerCourse("IS01","Fay");
registerCourse("SW01","Ali");

int choice;
System.out.println(" **** Welcome to Institute Course Registration System ****");
do {
System.out.println("---------------------------------------");
System.out.println("Choose one of these actions:");
System.out.println("(1) Add a new course");
System.out.println("(2) Register a course for a trainee, given the trainee name and course code");
System.out.println("(3) Cancel Course Registration");
System.out.println("(4) Find and Display the information of a course, given the course code");
System.out.println("(5) List All courses");
System.out.println("(6) Find and Display list of registered courses for a given trainee");
System.out.println("(7) Compute and Display the total tuition for a given trainee");
System.out.println("(8) Display total number of added courses");
System.out.println("(9) Exit");

choice = input.nextInt();
switch (choice) {
case 1 :
   System.out.println("Enter the course information:");
   System.out.print("Course Code in format LLDD, L: letter, D: digit:");
   String courseCode= input.next();
   System.out.print("weeklyTimeSlots in format D-S-E:");
   String weeklyTimeslots= input.next();
   System.out.print("finalExamDate in format: DD/MM/YY:");
   String finalExamdate= input.next();
   System.out.print("Tution:");
   double tuition = input.nextDouble();
   
   if(addCourse(courseCode, weeklyTimeslots, finalExamdate, tuition))
      System.out.println("The course is added successfully");
   else
      System.out.println("course is not added!");

break;

case 2 :
   System.out.print("Please enter course code: ");
   String inputCode = input.next();
   System.out.print("Please enter trainee name: ");
   String inputName = input.next();
   
   if(registerCourse(inputCode, inputName)) 
      System.out.println("Course is registered successfully. ");
   else 
      System.out.println("Course is not registered.");
 
break;

case 3 :
   System.out.println("Please enter course code: ");
   inputCode= input.next();
   System.out.println("Please enter trainee name: ");
   String inputTrainee= input.next();
   
   if ( cancelCourseRegistration( inputCode , inputTrainee) )
      System.out.println("Course registration is cancelled successfully.");
   else
      System.out.println("Course is not cancelled.");

break;

case 4 :
   System.out.println("Please enter course code: ");
   inputCode = input.next();
   int availability = findCourse(inputCode);
   if (availability != -1)
      courses[availability].DisplayCourseInfo();
   else 
      System.out.println("This course cannot be found.");

break;

case 5 :
printAll();
break;

case 6 :
   System.out.print("Please enter trainee name: ");
   inputName = input.next();

   Course [] traineeCourses = findRegisteredCourses(inputName);
   for (int i = 0 ; i < traineeCourses.length ; i++)
      System.out.println( traineeCourses[i].getCourseCode() );
break;

case 7 :
   System.out.print("Please enter trainee name: ");
   inputName = input.next();
   double tuitionSum = 0;
   Course [] tuitionList = findRegisteredCourses(inputName);
   if (tuitionList.length > 0){
      for (int i = 0 ; i < tuitionList.length ; i++)
         tuitionSum += tuitionList[i].getTuition(); 
   }
   else 
      System.out.println("This trainee has no registered courses. ");
      
   System.out.println("The total tuition is: "+ tuitionSum);
    
break;

case 8 :
   System.out.println("Total number of courses is: "+ Course.totalCourses);
break;

case 9 :
   System.out.println("Thank you");
break;

default :
   System.out.println("incorrect input.");

}//end switch
}while (choice != 9); 
}//end main

//--------------------------

public static boolean addCourse(String courseCode, String weeklyTimeSlots, String finalExamDate, double tuition) {
if (Course.totalCourses == 20) {
   System.out.println("The list is full. ");
   return false;}

int courseIndex = findCourse( courseCode );
if (courseIndex != -1){
   System.out.println("Course code is not unique. "); 
   return false; }
      
Course obj1 = new Course (courseCode, weeklyTimeSlots, finalExamDate,tuition);
courses[Course.totalCourses]= obj1;
Course.totalCourses++;
return true;

  

}
//--------------------------

public static boolean registerCourse(String courseCode, String traineeName){
int courseIndex = findCourse( courseCode );
if (courseIndex == -1){
   System.out.println("Course is not found. "); 
   return false; }
   
if (courses[courseIndex].numTrainees == 3 ){
   System.out.println("Course is unavailable because there's no capacity. "); 
   return false; }

Course[] tempList = findRegisteredCourses(traineeName) ;
if (tempList.length == 3) {
   System.out.println("Trainee schedule is full. ");
   return false; } 
   
String finalExam = courses[courseIndex].getFinalExamDate();
for (int i = 0 ; i < tempList.length ; i++){
      if (finalExam.equals( tempList[i].getFinalExamDate() )) {
      System.out.println("There's a conflict in final exam date. "); 
      return false ; } 
}

String courseSlots = courses[courseIndex].getWeeklyTimeSlots();
for (int j = 0 ; j < tempList.length ; j++){
      String traineeSlots = tempList[j].getWeeklyTimeSlots();
   
   if ((courseSlots.charAt(0) == traineeSlots.charAt(0) ||
        courseSlots.charAt(1) == traineeSlots.charAt(1) ||
        courseSlots.charAt(2) == traineeSlots.charAt(2)) && 
        courseSlots.substring(4).equals(traineeSlots.substring(4) )){ 
       
         System.out.println("There's a conflict in weekly time slots for "+ traineeName + " during " + tempList[j].getWeeklyTimeSlots()); 
         return false; }
}//close for loop

String[] newTraineeList = courses[courseIndex].getTraineeNames() ; 
newTraineeList[courses[courseIndex].numTrainees]= traineeName;
courses[courseIndex].numTrainees++;
return true ;  
}
//--------------------------

public static boolean cancelCourseRegistration(String courseCode, String TraineeName){
int courseIndex = findCourse( courseCode );
if (courseIndex == -1){
   System.out.println("Course is not found. "); 
   return false; }

String[] tempList = courses[courseIndex].getTraineeNames();

for (int j = 0; j < courses[courseIndex].numTrainees ; j++)
   if (tempList[j].equals(TraineeName)) {
      for (int z = j ; z < tempList.length-1 ; z++)//removing the trainee name 
         tempList[z] = tempList[z+1];  
    
   courses[courseIndex].numTrainees--;
   tempList[courses[courseIndex].numTrainees]="";
   courses[courseIndex].setTraineeNames(tempList);
   return true; 
   }//close if

return false;

}
//--------------------------

public static int findCourse (String courseCode) {

for (int i = 0; i < Course.totalCourses ; i++){
if (courses[i] != null) {
   if (courses[i].getCourseCode().equals(courseCode))
      return i;
      }//close if 
      }//close for loop
      
return -1 ;
  
}
//--------------------------

public static Course[] findRegisteredCourses(String traineeName) {
int regCourses=0;
//loop to create an array of proper length 
for (int x = 0 ; x < Course.totalCourses ; x++)
   if (courses[x] != null) 
   {
      for (int y = 0 ; y < courses[x].numTrainees ; y++) 
         if (courses[x].getTraineeNames()[y] != null)
            if (courses[x].getTraineeNames()[y].equals(traineeName)) 
               regCourses++;
   }
Course [] registeredCourses = new Course [regCourses];

//loop to add the registered courses to the created array
int index = 0 ; 
for (int x = 0 ; x < Course.totalCourses ; x++){
   if (courses[x] != null) 
   {
   for (int y = 0 ; y < courses[x].numTrainees ; y++)
    if (courses[x].getTraineeNames()[y] != null)
      if (courses[x].getTraineeNames()[y].equals(traineeName))
         registeredCourses[index++] = courses[x] ;
   }
}
return registeredCourses;      
}
//--------------------------
public static void printAll(){
for (int i = 0; i< Course.totalCourses ; i++)
   if (courses[i] != null) 
      System.out.println(courses[i].getCourseCode());}

}
