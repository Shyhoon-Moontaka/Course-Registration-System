import java.util.ArrayList;
import java.util.HashMap;

class Person{
    
    public String Username;
    public String Email;
    public String Password;
    public void Login(String username,String email,String password){
         Username=username;
         Email=email;
         Password=password;
    }
}
class Course{
    
        String CourseCode;
        String CourseTitle;
        String Credit;
    
    public void CourseDetails(String courseCode,String courseTitle,String credit){
        CourseCode=courseCode;
        CourseTitle=courseTitle;
        Credit=credit;
    }
}
class Student extends Person{ 
    
        public int StudentId;
        public String Year;
        public String Semester;
        public String Session;
        public ArrayList<Course> course=new ArrayList<>();
    
    public void CourseRegistration(Course course,int studentId,String year,String semester,String session){
        StudentId=studentId;
        Year=year;
        Semester=semester;
        Session=session;
        this.course.add(course);
    }
    public void ViewCourseSchedule(){
        for(Course i:this.course){
            System.out.println(i.CourseCode+" "+i.CourseTitle+" "+i.Credit);
        }
    }
    public void DropCourse(Course course){
        
        for(int i=0;i<this.course.size();i++){
            if(this.course.get(i)==course){
                this.course.remove(i);
            }
        }
    }
    public void DownloadAdmitCard(Student student){
        System.out.println("Admit Card");
        System.out.println(student.Username+" "+student.StudentId+" "+student.Year+" "+student.Semester+" "+student.Session);
        System.out.println("List of Courses");
        for(Course i:student.course){
        System.out.println(i.CourseCode+" "+i.CourseTitle+" "+i.Credit);
    }
    }

}
class Chairman{ 
    
    public ArrayList<Course> ApprovedCourse=new ArrayList<>();
    public ArrayList<Student> StudentList=new ArrayList<>();
    public HashMap<Course,String> CourseByInstructor=new HashMap<>();

    public void ApprovedCourse(Course course){
        ApprovedCourse.add(course);
    }
public void AssignInstructor(String InstructorName,Course course){
    CourseByInstructor.put(course,InstructorName);
}
public void ReviewStudentRegistration(Student student){
    this.StudentList.add(student);
}
public void GenerateReports(){
    System.out.println("Approved Courses");
    for(Course i:ApprovedCourse){
        System.out.println(i.CourseCode+" "+i.CourseTitle+" "+i.Credit);
    }

    System.out.println("List of Students");
    for(Student i:StudentList){
        System.out.println(i.Username+" "+i.Email+" "+i.StudentId+" "+i.Year+" "+i.Semester+" "+i.Session);
    }
    System.out.println("Assign Instructor");

    for(Course i:this.CourseByInstructor.keySet()){
        System.out.println(i.CourseTitle+" "+this.CourseByInstructor.get(i));
    }

}

}

class ExamController{ 
    
    
    public ArrayList<Student> StudentLi=new ArrayList<>();
    public HashMap<Course,String> ExamList=new HashMap<>();

   
public void ScheduleExam(Course course,String ExamDate){
    ExamList.put(course,ExamDate);
}
public void GenerateAdmitCard(Student student){
    System.out.println("Admit Card");
    System.out.println(student.Username+student.StudentId+student.Year+student.Semester+student.Session);
    System.out.println("List of Courses");
    for(Course i:student.course){
        System.out.println(i.CourseCode+" "+i.CourseTitle+" "+i.Credit);
    }
}
public void PublishExamResult(Student student,String grade){
    System.out.println("Result of Student");
    System.out.println(student.Username+" "+student.StudentId+" "+grade); 
}
}
public class LabTask{
    public static void main(String[] args){
        Student student1=new Student();
        student1.Login("Shyhoon","shyhoon@gmail.com","12345");
        Student student2=new Student();
        student1.Login("Shaharia","shaharia@gmail.com","56789");
        Course course1=new Course();
        course1.CourseDetails("cse2101", "oop", "3.00");
        Course course2=new Course();
        course2.CourseDetails("cse2103", "algorithm", "3.00");
        student1.CourseRegistration(course1,210105,"2nd","1st","2021-22");
        student1.CourseRegistration(course2,210105,"2nd","1st","2021-22");
        student1.DropCourse(course1);
        student1.ViewCourseSchedule();
        student1.DownloadAdmitCard(student1);
        Chairman chairman=new Chairman();
        chairman.ApprovedCourse(course1);
        chairman.ApprovedCourse(course2);
        chairman.AssignInstructor("Jamil Sir", course1);
        chairman.AssignInstructor("Ratul Sir", course2);
        chairman.ReviewStudentRegistration(student1);
        chairman.ReviewStudentRegistration(student2);
        chairman.GenerateReports();
        ExamController examController=new ExamController();
        examController.ScheduleExam(course1,"10.05.2024");
        examController.ScheduleExam(course2,"15.05.2024");
        examController.GenerateAdmitCard(student1);
        examController.PublishExamResult(student1, "A");
    }
}
