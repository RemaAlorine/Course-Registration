public class Course {
private String courseCode;
private String weeklyTimeSlots ;
private String finalExamDate;
private String[] traineeNames ; 
private double tuition ;
public int numTrainees ;
public static int totalCourses ;

public Course(){
courseCode = "";
weeklyTimeSlots ="";
finalExamDate="";
tuition = 0;
traineeNames = new String [3]; 
}

public Course (String theCourseCode ,String CTimeSlots, String CFinalExamDate , double CTuition){
courseCode = theCourseCode;
weeklyTimeSlots = CTimeSlots;
finalExamDate = CFinalExamDate;
tuition = CTuition;
traineeNames = new String [3]; 
}

public void setCourseCode(String courseCode){
this.courseCode= courseCode; 
}

public void setWeeklyTimeSlots (String weeklyTimeSlots) {
this.weeklyTimeSlots=weeklyTimeSlots;
}

public void setFinalExamDate (String finalExamDate) {
this.finalExamDate=finalExamDate;
}

public void setTuition (double tuition) {
this.tuition=tuition;
}

public void setTraineeNames (String[] traineeNames) {
numTrainees = 0 ;
for (int i = 0 ; i < 3 ; i++){ 
   this.traineeNames[i] = traineeNames[i] ;
   numTrainees++;  }
}

public String getCourseCode(){
return courseCode;
}

public double getTuition(){
return tuition;
}

public String getWeeklyTimeSlots() {
return weeklyTimeSlots;
}

public String getFinalExamDate() {
return finalExamDate;
}

public String[] getTraineeNames() {
return traineeNames ; 
}

public void DisplayCourseInfo() {
System.out.println("***** Course Information *****");
System.out.println("Course Code: "+ courseCode);
System.out.println("Course Availability: " +  (numTrainees >= 3 ? "Not available" : "Available"));
System.out.println("Tuition: "+ tuition);
System.out.println("Weekly Time Slots: \n Day "+ weeklyTimeSlots.substring(0,3) +"   Time "+ weeklyTimeSlots.substring(4));
System.out.println("Final Exam Date: \n Day: "+ finalExamDate.substring(0,2) +"   Month: "+finalExamDate.substring(3,5) +
                   "    Year: " + finalExamDate.substring(6));

}
 

}
