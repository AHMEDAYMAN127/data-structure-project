package javaapplication7;
import java.util.Stack;
public class enrolll {
    private Stack<Action> undostack= new Stack<>();
    private Stack<Action> redostack= new Stack<>();
    private Student student;
    private Course course;
    public  enrolll()
    {
    student= new Student();
    course= new Course();
    }
    public void addstudent(int id){
   student.addstudent(id);
   }
    public void removestudent(int id){
   student.removestudent(id);
   }
    public void getlaststudentadded(){
   student.getlaststudentadd();
   }
    public void addcourse(int id){
    course.addcourse(id);
    }
    public void removecourse(int id){
    course.removeCourse(id);
    }
    public void getlastcourseadded(){
    course.getlastcourseadded();
    }
    public void enrollstudentt(int studentid,int courseid){
        if(!cheakenrolledcourses(courseid)){
        return;
        }
        
    if(!student.cheakstudents(studentid))
    {
        System.out.println("invaild studentid");
        return;
    }
    if(!course.cheakcourses(courseid)){
    System.out.println("invaild courseid");
        return;
    }
    Studentnode follow=student.head;
    courselink hi;
    while(follow != null){
    if(follow.data==studentid){
        hi=follow.enrolledcourses;
        while(hi!=null){
        if(hi.courseid==courseid){
            System.out.println("you already enrolled this course");
            return;
        }
        hi=hi.next;    
        }
    courselink newcourse=new courselink(courseid);
    newcourse.next=follow.enrolledcourses;
    follow.enrolledcourses = newcourse;
    break;
    }
    follow=follow.next;
    }
    CourseNode hello=course.head;
    while(hello!=null){
    if(hello.data==courseid){         
    studentlink newstudent=new studentlink(studentid);
    newstudent.next=hello.enrolledstudent;
    hello.enrolledstudent = newstudent;
    break;
    }
    hello=hello.next;
    }
    System.out.println("enrollment successful");
    //stack
    undostack.push(new Action("add",studentid,courseid));
    redostack.clear();
    
    }
    public void courseslist(int studentid){
    if(!student.cheakstudents(studentid))
    {
        System.out.println("invaild studentid");
        return;
    }
    courselink hi;
    Studentnode follow=student.head;
    while(follow!=null){
        if(follow.data==studentid){
            hi=follow.enrolledcourses;
            if(hi==null){
        System.out.println("no courses added by student "+studentid);
        return;
    }
            System.out.println("");
            System.out.println("student "+studentid+" course list: ");
        while(hi!=null){
            System.out.println("course: "+hi.courseid+"  ");
        hi=hi.next;
        }
        System.out.println("");
        return;
        }
        follow=follow.next;
    }
    
    }
    public void studentlist(int courseid){
    if(!course.cheakcourses(courseid)){
    System.out.println("invaild courseid");
        return;
    }
    CourseNode follow=course.head;
    studentlink hi;
    while(follow!=null){
    if(follow.data==courseid){
    hi=follow.enrolledstudent;
    
    if(hi==null){
        System.out.println("no student added the course");
        return;
    }
    System.out.println("");
    System.out.println("student who enroll course "+courseid+": ");
    while(hi!=null){
        System.out.println("student: "+hi.studentid);
    hi=hi.next;
    }
    System.out.println("");
    return;
    }
    follow=follow.next;
    }
    }
    private boolean cheakenrolledcourses(int courseid){
CourseNode follow=course.head;
studentlink hello;
while(follow!=null){
if(follow.data==courseid){
hello=follow.enrolledstudent;
int n=0;
while(hello!=null){
n++;
if(n==30){
    System.out.println("the course is full please choose another one");
return false;
}
hello=hello.next;
}
}
follow=follow.next;

}
return true;
}
    public void removeenrollment(int studentid,int courseid){
    if(!student.cheakstudents(studentid))
    {
        System.out.println("invaild studentid");
        return;
    }
    if(!course.cheakcourses(courseid)){
    System.out.println("invaild courseid");
        return;
    }
    CourseNode follow=course.head;
    studentlink ahmed;
    while(follow!=null){
    if(follow.data==courseid){
    ahmed=follow.enrolledstudent;
    while(ahmed!=null){
    if(ahmed.studentid==studentid){
    ahmed=ahmed.next;    
    follow.enrolledstudent=ahmed;
    break;
    }
    ahmed=ahmed.next;
    }
    
    }
    follow=follow.next;
    }
    
    
    Studentnode hi=student.head;
    courselink ad;
while(hi!=null){
if(hi.data==studentid){
    ad=hi.enrolledcourses;
    while(ad!=null){
    if(ad.courseid==courseid){
    ad=ad.next;
    hi.enrolledcourses=ad;
        System.out.println("removed successful");
    break;
    }
    ad=ad.next;
    }
}
hi=hi.next;
}
//stack
undostack.push(new Action("remove",studentid,courseid));
redostack.clear();
}
    public void isfullcourse(int courseid){
    if(!course.cheakcourses(courseid)){
    System.out.println("invaild courseid");
        return;
    }
    CourseNode follow=course.head;
    studentlink hi;
    int n=0;
    while(follow!=null){
    if(follow.data==courseid){
    hi=follow.enrolledstudent;
    if(hi==null){
        System.out.println("no student added the course");
        return;
    }
    while(hi!=null){
        ++n;
    hi=hi.next;
    if(n==30){
        System.out.println("course is full");
        return;
    }
    }
    int m=30-n;
            System.out.println("course "+courseid+" need "+m+" student to be full.");
    }
    follow=follow.next;
    }
    
    
    
    }
    public void isnormalstudent(int studentid){
Studentnode follow=student.head;
courselink hii;
while(follow!=null){
if(follow.data==studentid){
hii=follow.enrolledcourses;
int n=0;
if(hii==null){
    System.out.println("no enrolled courses");
    return;
}
while(hii!=null){
++n;
if(n>7){
    System.out.println("student "+studentid+" enrolled more than the max ");
    return;
}
hii=hii.next;    
}
    System.out.println("student "+studentid+" is normal,he enrolled: "+n);
}
follow=follow.next;
}





}
    public void sortstudentsbyid(){
    Studentnode end=null;
    int n;
    while(end!=student.head){
        Studentnode current=student.head;
        Studentnode currentnext=current.next;
    while(currentnext!=end){
    if(current.data>currentnext.data){
    n=current.data;
    current.data=currentnext.data;
    currentnext.data=n;
    }
    current=current.next;
    currentnext=current.next;
    }
    end=current;
    }
    
    System.out.println("student sorted list:");
    end=student.head;
    while(end!=null){
        System.out.println("student: "+end.data);
    end=end.next;
    }

    }
    public void sortcoursesbyid(){
    CourseNode end=null;
    int n;
    while(end!=course.head){
    CourseNode current=course.head;
    CourseNode currentnext=current.next;
    while(currentnext!=end){
    if(current.data>currentnext.data){
    n=current.data;
    current.data=currentnext.data;
    currentnext.data=n;
    }
    current=current.next;
    currentnext=current.next;    
    }
    end=current;
    }
    end=course.head;
        System.out.println("courses sorted list:");
        while(end!=null){
            System.out.println("course: "+end.data);
        end=end.next;
        }
    
    
    
    
    
    }      
    public void undo(){
        if(!undostack.isEmpty()){
        Action lastaction=undostack.pop();
        if(lastaction.type.equals("add")){
        removeenrollment(lastaction.studentid,lastaction.courseid);
System.out.println("--> student "+lastaction.studentid+" from course "+lastaction.courseid);
System.out.println("");
        }else if(lastaction.type.equals("remove")){
        enrollstudentt(lastaction.studentid,lastaction.courseid);
        System.out.println("--> student "+lastaction.studentid+" to course "+lastaction.courseid);
System.out.println("");
        }
   redostack.push(lastaction);
        }
        else{
            System.out.println("no thing to Undo");
            System.out.println("");
        }
    }
    public void redo(){
    if(!redostack.isEmpty()){
    Action lastaction=redostack.pop();
    if(lastaction.type.equals("remove")){
    removeenrollment(lastaction.studentid,lastaction.courseid);
    System.out.println("--> student "+lastaction.studentid+" from course "+lastaction.courseid);   
   System.out.println("");
    }else if(lastaction.type.equals("add")){
    enrollstudentt(lastaction.studentid,lastaction.courseid);
    System.out.println("--> student "+lastaction.studentid+" to course "+lastaction.courseid);   
   System.out.println("");
    }
    undostack.push(lastaction);
    }else{
        System.out.println("no thing to Redo");
        System.out.println("");
    }
    }
}
  
        
        
        
        
        
        
        
        
        
    


    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
    
    
    
    
    
    
    
    
    


