
package assignment02;

/**
 * 
 * @author Freeman
 */

import java.io.*;
import java.util.*;

public class StudentResultClient 
{
    /**
     * Global Variables and ArrayList for the students and the courses
     */
    public static int FirstOption; // Global variable of first option
    public static Scanner read = new Scanner(System.in); // Global variable for the scanner
    ArrayList<Student> students = new ArrayList<Student>(); // ArrayList of the students
    ArrayList<Student> courses = new ArrayList<Student>(); // ArrayList of the courses 
    
    
    /**Method to store output of My student particulars 
     */
    // For the StudentInfo
    public static void StudentInfo() // For the StudentInfo
    {
        System.out.println("Name: Tan Hong Rui Freeman");
        System.out.println("Student No: 34177608");
        System.out.println("Enrolment: Computer Science ICT167(A)");
        System.out.println("Tutor Name: Tan Han Kee");
    } // END OF STUDENTINFO
    
    /**The method to add student details from student text-file to ArrayList
     */ 
    // Reading the file of student.txt
    public void readStudents()
    {
       Scanner readStudFile = null; // Scanner class object declared
        
       // Try-Block
        try
        {
            readStudFile = new Scanner(new File("student.txt")); // Opening the file to read
            while(readStudFile.hasNextLine()) // LOOPING it till end of the files to read the records
            {
                String stud = readStudFile.nextLine();
                String[] eachStud = stud.split(" ");
                
                // Adding those records to the students arraylist
                students.add(new Student(eachStud[0], eachStud[1], eachStud[2], 
                        Long.parseLong(eachStud[3]),Integer.parseInt(eachStud[4]),
                        Integer.parseInt(eachStud[5]), Integer.parseInt(eachStud[6])));
            } // END OF WHILE LOOP
        } // END OF TRY BLOCK
        // Catch Exception if the file is not found
        catch(FileNotFoundException ex)
        {
            System.out.println("--- *ERROR: FILE IS NOT FOUND.* ---");
        }
        // Close the file
        readStudFile.close(); 
    }// END OF READSTUDENTS
    
    /**The method to add coursework student text file into ArrayList
     */ 	
    // Case: 2
    public void addDataCourseFile()
    {
        Scanner readCourseFile = null; // Scanner class object declared
     
         // Try-Block
        try
        {
            readCourseFile = new Scanner(new File("courseWorkStudent.txt")); // Opening the file to read
            
            while(readCourseFile.hasNextLine()) // LOOPING it till end of the files to read the records
            {
                String course = readCourseFile.nextLine();
                String[] eachCourse = course.split(" ");
                int position = searchStudentID(Long.parseLong(eachCourse[0]));
                
                if (position != -1)
                {
                    // Adding a courses arraylist to get the records from the students arraylist
                    // CourseWorkStudent Searching
                    courses.add(new CourseWorkStudent(
                    students.get(position).getTitle(),
                    students.get(position).getFirstName(),
                    students.get(position).getLastName(),  
                    students.get(position).getId(),    
                    students.get(position).getDay(),    
                    students.get(position).getMonth(),   
                    students.get(position).getYear(),
                    Double.parseDouble(eachCourse[1]),
                    Double.parseDouble(eachCourse[2]), 
                    Double.parseDouble(eachCourse[3]), 
                    Double.parseDouble(eachCourse[4]))); 
                } // END OF IF  
            } // END OF WHILE 
            System.out.println("--- [Student.txt] and [CourseWorkStudent.txt] File Added/Readed. ---");
            // calculate the coursework student grades and marks method.
            calculateGradeAndMarksCourse();
        } // END OF TRY BLOCK
        // Catch Exception if the file is not found
        catch(FileNotFoundException ex)
        {
            System.out.println("--- *ERROR: FILE IS NOT FOUND.* ---");
        }
        // Close the file
        readCourseFile.close();
    } // END of addDataCourseFile
    
    /**The method to add research student text file into ArrayList
     */ 
    public void addResearchFile()
    {
        Scanner readResearchFile = null; // Scanner class object declared
        
        // Try-Block
        try
        {
            readResearchFile = new Scanner(new File("researchStudent.txt")); // Opening the file to read
            
         while(readResearchFile.hasNextLine()) // LOOPING it till end of the files to read the records
         {
               String research = readResearchFile.nextLine();
               String[] eachResearch = research.split(" ");
               int position = searchStudentID(Long.parseLong(eachResearch[0]));
                     
               if (position != -1)
                {
                    // Adding a courses arraylist to get the records from the students arraylist
                    // Research Student Searching
                    courses.add(new ResearchStudent(
                    students.get(position).getTitle(),
                    students.get(position).getFirstName(),
                    students.get(position).getLastName(),
                    students.get(position).getId(),
                    students.get(position).getDay(),
                    students.get(position).getMonth(),
                    students.get(position).getYear(),
                    Double.parseDouble(eachResearch[1]),
                    Double.parseDouble(eachResearch[2]),
                    Double.parseDouble(eachResearch[3])));
                } // END OF IF    
         } // END OF WHILE
          System.out.println("--- [Student.txt] and [ResearchStudent.txt] File Added/Readed. ---");
            // calculate the research student grades and marks method.
            calculateGradeAndMarksRS();
        } // END OF TRY BLOCK 
        // Catch Exception if the file is not found
        catch(FileNotFoundException e)
        {
            System.out.println("--- *ERROR: FILE IS NOT FOUND.* ---");
        }
        // Close the file
        readResearchFile.close();
    }
    
    // Calculation of CourseWorkStudent Grades and marks for Case 2:
   public void calculateGradeAndMarksCourse()
   {
       // Calculate grades for CourseWorkStudent
       for(int i = 0; i < courses.size(); i++) 
       {
           if(courses.get(i) instanceof CourseWorkStudent) // Check the index object is an instance of the CourseWorkStudent
           {
               CourseWorkStudent cw = (CourseWorkStudent) courses.get(i); 
               cw.CourseWorkGrading(); // Calling the CourseWorkGrading method from CourseWorkStudent Class
           }// END OF IF
       }// END OF FOR    
   }// END OF calculateGradeAndMarksCourse
   
    // Calculation of ResearchStudent Grades and marks for Case 2:
   public void calculateGradeAndMarksRS()
   {
   // Calculate grades for ResearchStudent
       for(int i = 0; i < courses.size(); i++)
       {
           if(courses.get(i) instanceof ResearchStudent) // Check the index object is an instance of the ResearchStudent
           {
               ResearchStudent rs = (ResearchStudent) courses.get(i);
               rs.ResearchGrading(); // Calling the CourseWorkGrading method from ResearchStudent Class
           }// END OF IF
       }// END OF FOR
   }// END OF calculateGradeAndMarksRS
   
   
   /**The method to remove student in ArrayList with ID
    */ 
   // Case: 3 
   public void removeStudent()
   {  
       long ID;
       // Printing statement to ask the user
       System.out.print("Enter Student ID to be removed: "); 
       ID = read.nextLong();
       /**Using Nested FOR Loop to check the students ArrayList and Courses ArrayList
        */
       for(int i = 0; i<students.size(); i++)
       {
         for(int j = 0; j<courses.size(); j++)
          { 
              Student obj = students.get(i); // object declared
              Student obje = courses.get(j); // object declared
              /**Using IF statements to check object ID from students ArrayList call getId method and Courses ArrayList call getId method.
               * Using another IF Statements to check with the user if they wish to delete this record.
               * If it is "Y" or "y" it will remove the record from both students and courses ArrayList.
              */
              if(ID == obj.getId() && ID == obje.getId() )
              {
                 System.out.println("Student details to be deleted.");
                 System.out.println(obj.toString());
                 System.out.println("Do you want to delete it? [Y/N]: ");
                 String str = read.next();
                 if(str.equalsIgnoreCase("y"))
                 {
                    students.remove(i);
                    courses.remove(j);
                    System.out.println("Student detail has been deleted!");
                 }// END OF "Y" IF
                 return;
              }// END OF IF     
         }// END OF FOR 
      }// END OF FOR
       // Print-out statements
        System.out.println("--- ERROR: Student ID Not Found! ---"); 
    }// END OF removeStudent
     
   /**The method to check print all of student details in ArrayList
    */ 
   // Case: 4
    public void printAllStudents() 
    {
        /**Using FOR Loop to check the students at Courses ArrayList
         * Print-out the students information at that Courses
         * By calling the toString method too from the class
        */
       for(int i=0; i<courses.size(); i++)
       {
          System.out.println(courses.get(i).toString());
       }// END OF FOR
    }// END FOR printAllStudents
     
    /**The method to check overall marks and grades of coursework student
     */	  
   // Case: 5
   public void CourseOverallMarkGrade()
   {
        double total = 0;
        /**Using FOR Loop to check the students at Courses ArrayList.
         * Creating an Object Declare.
         * Creating an total variable.
         * Using the IF statements to check theObject index declare Check is it an instance of the CourseWorkStudent.
         * If it is we will print-out the Overall Marks and Grade by calling.
         * GetCourseWorkOverallMark Method and CourseWorkGrading Method.
         * For the total We will be using the same method too.
         */
        for(int i=0; i<courses.size();i++)
        { 
          Object obj = courses.get(i);
            if(obj instanceof CourseWorkStudent)
            {
               System.out.println(((CourseWorkStudent)obj).getCourseWorkOverallMark()+"\t"+
                       ((CourseWorkStudent)obj).CourseWorkGrading());
            }// END OF IF
            if(obj instanceof CourseWorkStudent)
            {
               total = total+((CourseWorkStudent)obj).getCourseWorkOverallMark();
            }// END OF IF
        }// END OF FOR
        // Print-out statements
        System.out.println();
        System.out.println("Overall Mark For CourseWorkStudents: " +total);
   }// END OF CourseOverallMarkGrade
   
   /**The method to check overall marks and grades of research student
     */	  
   public void ResearchOverallMarkGrade()
   {
       double total = 0;
         /**Using FOR Loop to check the students at Courses ArrayList.
         * Creating an Object Declare.
         * Creating an total variable.
         * Using the IF statements to check the Object index declare Check is it an instance of the ResearchStudent.
         * If it is we will print-out the Overall Marks and Grade by calling.
         * getResearchOverallMark Method and ResearchGrading Method.
         * For the total We will be using the same method too.
         */
       for(int i=0; i<courses.size(); i++)
       {
           Object obj = courses.get(i);
            if(obj instanceof ResearchStudent)
           {
               System.out.println(((ResearchStudent)obj).getResearchOverallMark()+"\t"+
                       ((ResearchStudent)obj).ResearchGrading());
           }// END OF IF
           if(obj instanceof ResearchStudent)
           {
               total = total+((ResearchStudent)obj).getResearchOverallMark();
           }// END OF IF
       }//END OF FOR
       // Print-out statements
       System.out.println();
       System.out.println("Overall Mark For ResearchStudent: " +total);
   }// END OF ResearchOverallMarkGrade
     
   /**The method to check above and below average marks of Coursework students
    */ 
    // Case: 6
    public void showCourseWorkStudentBelowAboveAvg()
    {
        double total = 0.0;
        int counter = 0;
         /**Using FOR Loop to check the students at Courses ArrayList.
         * Creating an Object Declare.
         * Creating an counter variable
         * Creating an total variable
         * Using IF statement to check the Object index declare Check is it an instance of the CourseWorkStudent
         * Calculate the total overall mark with counter.
         * Using getCourseWorkOverallMark() for the total
         */
        for(int i = 0; i < courses.size(); i++)
        {
            if(courses.get(i) instanceof CourseWorkStudent)
            {
                CourseWorkStudent cw = (CourseWorkStudent) courses.get(i);
                total += cw.getCourseWorkOverallMark();
                counter++;
            }// END OF IF
        }// END OF FOR
        
        double avg = total / counter; // Calculation of the average marks
        // Printing statements
         /**Using FOR Loop to check the students at Courses ArrayList.
         * Using IF statement to check the Object index declare Check is it an instance of the CourseWorkStudent.
         * Using another IF Statement to check how many students get the above average mark.
         * Using getCourseWorkOverallMark() > avg to check the is it more than the average mark.
         * Print-out the students that has the above average marks. 
         */
        System.out.print("---- Number of student above average ----");
        for(int i = 0; i < courses.size(); i++)
        {
           if(courses.get(i) instanceof CourseWorkStudent)
           {    
            CourseWorkStudent cw = (CourseWorkStudent) courses.get(i);
            if(cw.getCourseWorkOverallMark() > avg)
            {
                System.out.println(cw);
            }// END OF IF
           }// END OF IF
        }// END OF FOR
        
         System.out.println();
        // Printing statements
        System.out.print("---- Number of student below average ----");
         /**Using FOR Loop to check the students at Courses ArrayList.
         * Using IF statement to check the Object index declare Check is it an instance of the CourseWorkStudent.
         * Using another IF Statement to check how many students get the below average mark.
         * Using getCourseWorkOverallMark() below avg to check the is it lesser than the average mark.
         * Print-out the students that has the below average marks. 
         */
        for(int i = 0; i < courses.size(); i++)
        {
           if(courses.get(i) instanceof CourseWorkStudent)
           {   
            CourseWorkStudent cw = (CourseWorkStudent) courses.get(i);
            if(cw.getCourseWorkOverallMark() < avg)
            {
                System.out.println(cw);
            }// END OF IF
           }// END OF IF
        }// END OF FOR
    }// END OF showCourseWorkStudentBelowAboveAvg
    
     /**The method to check above and below average marks of Research students
     */ 
    public void showResearchStudentBelowAboveAvg()
    {
        /**Using FOR Loop to check the students at Courses ArrayList.
         * Creating an Object Declare.
         * Creating an counter variable
         * Creating an total variable
         * Using IF statement to check the Object index declare Check is it an instance of the ResearchStudent
         * Calculate the total overall mark with counter.
         * Using getResearchOverallMark() for the total
         */
        double total = 0.0;
        int counter = 0;
        for(int i = 0; i < courses.size(); i++)
        {
            if(courses.get(i) instanceof ResearchStudent)
            {
                ResearchStudent re = (ResearchStudent) courses.get(i);
                total += re.getResearchOverallMark();
                counter++;
            }// END OF IF
        }// END OF FOR
        double avg = total / counter; // calculation of the average marks
        // Printing statements
        System.out.println("---- Number of student above average ----");
         /**Using FOR Loop to check the students at Courses ArrayList.
         * Using IF statement to check the Object index declare Check is it an instance of the ResearchStudent.
         * Using another IF Statement to check how many students get the above average mark.
         * Using getResearchOverallMark() > avg to check the is it more than the average mark.
         * Print-out the students that has the above average marks. 
         */
        for(int i = 0; i < courses.size(); i++)
        {
           if(courses.get(i) instanceof ResearchStudent)
           {
            ResearchStudent re = (ResearchStudent) courses.get(i);
            if(re.getResearchOverallMark() > avg)
            {
                System.out.println(re);
            }// END OF IF
          }// END OF IF
        }// END OF FOR
        
        System.out.println();
        // Printing Statements
        System.out.println("---- Number of student below average ----");
         /**Using FOR Loop to check the students at Courses ArrayList.
         * Using IF statement to check the Object index declare Check is it an instance of the ResearchStudent.
         * Using another IF Statement to check how many students get the below average mark.
         * Using getResearchOverallMark() below avg to check the is it lesser than the average mark.
         * Print-out the students that has the below average marks. 
         */
        for(int i = 0; i < courses.size(); i++)
        {
          if(courses.get(i) instanceof ResearchStudent)
         {
            ResearchStudent re = (ResearchStudent) courses.get(i);
            if(re.getResearchOverallMark() < avg)
            {
                System.out.println(re);
            }// END OF IF
         }// END OF IF
       }// END OF FOR
    }// END OF showResearchStudentBelowAboveAvg
    
    
    /**The method to search by Student ID 
     */ 
   // Case: 7
    public int searchStudentID(long id)
    {
        /**Using FOR Loop to check the students ID requested by the user at Students ArrayList.
         * Print-out that student ID information only.
         * By calling the getId method to get that specific student ID.
         * IF the student ID is found it will @return i
         * If Not found it will @return -1
        */
       for(int i=0; i < students.size();i++) 
       {
           Student obj = students.get(i);
           if(id == (obj.getId())) 
           {
               return i;
           }// END OF IF
        }// END OF FOR  
       return -1;
    }// END OF searchStudentID(long id)
    
    /**The method to search by name and print out all particulars
     */ 
     // Case: 8
    public void searchName() 
    {
       int found = -1; // Found variables
       Scanner in=new Scanner(System.in); // Declaring Scanner
       String name; // String Variables
       // Printing statements
       System.out.print("Enter student name[First Name] and [Last Name] to Search: ");
       name=in.nextLine();
       /**Using FOR Loop to check the students full name requested by the user at Courses ArrayList.
         * Print-out that student full name information only.
         * By calling the getName method to get that specific student information.
         * IF the student name is found it will print-out the information of that student.
         * If Not found it will trigger the -1 and print-out "Student not found!" statement.
        */
       for(int i=0; i < courses.size();i++) 
       {
           //Student obj=courses.get(i);
           if(name.equalsIgnoreCase(courses.get(i).getName())) 
           {
               System.out.println("--- Student details ---");
               System.out.println(courses.get(i));
               found = i;
           }// END OF IF
       }// END OF FOR
       if(found == -1)
       {
           System.out.println("Student not found!");
       }// END OF IF
    }// END OF searchName
    
    /**The method to sort the student ID in ascending order
     */ 
    // Case: 9
     public void sortStudent()
     {
         /**Using NESTED FOR Loop to check courses ArrayList and using 2 index variable.
         * Using IF statements to compare the student ID
         * By calling the getId method
         * Using the Collections swap method to arrange the student ID in ascending order.
         * Lastly print-out statements of the sorted student ID.
        */
      for(int i=0; i<courses.size(); i++)
      {
         for(int j=1; j<(courses.size()-i);j++)
         {
            if(courses.get(j).getId() < courses.get(j-1).getId())
            {
               Collections.swap(courses, j, j-1);
            }// END OF IF
         }// END OF FOR   
      }// END OF FOR
      System.out.println("--- Sorted Student By ID ---");
      System.out.println(courses);
   }// END OF sortStudent
    
     
     /**The method to print out the data into a CSV file
      */ 
    // case: 10
    public void saveToCSV(String filename)
    {
        try // TRY-BLOCK
        {
            File file = new File(filename); // create a new file
            FileWriter filewriter = new FileWriter(file); // Start writing a new file
            /** Using he FOR loop to check the updated courses ArrayList.
             * By declaring a student object equal to the courses ArrayList getting that index
             * After that we do a FileWriter to write it out as an CSV Format by calling the toStringCSVFormat from the classes
             * Lastly we will close the file when done writing it.
             */
            for(int i=0; i<courses.size(); i++)
            {
                Student obj = courses.get(i);
                filewriter.write(obj.toStringCSVFormat());
            }// END OF FOR
            filewriter.close();
        }// END OF TRY BLOCK
        // Catch Exception if the file can't be trace
        // CATCH BLOCK
        catch(Exception ex)
        {
            ex.printStackTrace();
        }// END OF CATCH
        // Printing statements
        System.out.println("File saved to [output.csv]");
    }// END OF saveToCSV(String filename)
    
    
    /**The method of printing 1-10 menus
     * And asking the user input the menu option by using Integer
     */         
    public static int menuPrinting()
    {
        System.out.println();
        System.out.println("---- MENU ----");
        System.out.println("[1] Quit(Exit the program).");
        System.out.println("[2] Add student data to arraylist.");
        System.out.println("[3] Remove a student info.");
        System.out.println("[4] Information of all students.");
        System.out.println("[5] Display overall mark and grade from all students.");
        System.out.println("[6] Number of students above or below average marks. ");
        System.out.println("[7] Information of a specific student by student ID.");
        System.out.println("[8] Search a student information by name(both first-name and last-name)");
        System.out.println("[9] Sort the student order by student ID.");
        System.out.println("[10] Save it to CSV File."); 
        System.out.println();
        System.out.println("Enter a choice/option: ");
        
        return read.nextInt();
    }
    
    /**The method of printing 1-10 menus function
     * And calling each individual methods at each case
     * Using a do-while loop to prompt the user for more menus option
     */ 
     public static void Menu()
     {
         /** Switch Case.
          * Case 1 is to exiting the program.
          * Case 2 is to add the data of researchstudent.txt and courseworkstudent.txt. By using addDataCourseFile() and addResearchFile() methods.
          * Case 3 is to remove a student by entering the student ID only. By using removeStudent() method.
          * Case 4 is to print-out all the student from that course only by using printAllStudents() method.
          * Case 5 is to print-out all the marks and grades from that course only by using CourseOverallMarkGrade() and ResearchOverallMarkGrade() methods.
          * Case 6 is to print-out all the above and below average marks from that course only by using showCourseWorkStudentBelowAboveAvg() and showResearchStudentBelowAboveAvg() methods.
          * Case 7 is to search the student by entering the student ID only. By using searchStudentID(id) method.
          * Case 8 is to search the student by entering the student full name only. By using searchName() method.
          * Case 9 is to sort the student in ascending order by the student ID number. By using sortStudent() method.
          * Case 10 is to output the most updated ArrayList to an CSV File. By using saveToCSV("output.csv") method.
          * Default if the user enter an invalid number it will prompt an invalid choice statement.
          */
        StudentResultClient mainClient = new StudentResultClient(); // Declaring Object
        mainClient.readStudents(); // Reading the student.txt File by calling readStudent method
        
       do
        {  
            switch(mainClient.menuPrinting() ) // Switch case and calling menuPrinting method to show the menus
            {
                case 1: 
                    System.out.println("--- EXITING PROGRAM ---"); 
                    System.exit(0);
                case 2: 
                    //addData
                    if(FirstOption == 1)
                       mainClient.addDataCourseFile();
                    else if(FirstOption == 2)
                       mainClient.addResearchFile();
                    else
                        System.out.println("Invalid Choices!");
                    break;
                case 3:
                    // RemoveAStudent
                        mainClient.removeStudent();
                    break;
                case 4:
                    // printAllStudents 
                       mainClient.printAllStudents(); 
                    break;
                case 5:
                    // printOverallMarkGrade
                    if(FirstOption == 1)
                    {
                        System.out.println("--- CourseWorkStudent Mark & Grade ---"); 
                        mainClient.CourseOverallMarkGrade();
                    }
                    else if(FirstOption == 2)
                    {
                        System.out.println("--- Research Mark & Grade ---"); 
                        mainClient.ResearchOverallMarkGrade();
                    }
                    else
                        System.out.println("Invalid Choices!");
                    break;
                case 6:
                    // aboveBelowAverageMark
                    if(FirstOption == 1)
                        mainClient.showCourseWorkStudentBelowAboveAvg();
                    else if(FirstOption == 2)
                        mainClient.showResearchStudentBelowAboveAvg();
                    else
                        System.out.println("Invalid Choices!");
                    break;
                case 7:
                    // searchStudentByID
                    
                     System.out.print("Enter student ID to search: ");
                     long id = mainClient.read.nextLong(); 
                     int pos = mainClient.searchStudentID(id);
                     if(pos == -1)
                         System.out.println("ERROR: No Student found on ID: " + id);
                     else
                     {
                         System.out.println(mainClient.students.get(pos)); 
                     } 
                    break;
                case 8:
                    // searchStudentName
                    mainClient.searchName();
                    break;
                case 9:
                    // sortStudentByID
                    mainClient.sortStudent();
                    break;
                case 10:
                    // saveToCSVFile
                    mainClient.saveToCSV("output.csv");
                    break;
                default:
                    System.out.println("Invalid Choice/Option!, Please Try Again.");
                }// END OF SWITCH
        }while(true); // END OF DO-WHILE
     }// END OF Menu
    
     /**The main method that runs all the switch cases and 3 other class accordingly
      * 
      * @param args command-line arguments
      */
    public static void main(String[] args) 
    { 
        /** Main Method.
         * It will call my StudentInfo() Method first to print-out my details.
         * Using the While Loop to prompt the user if they want to see CourseWorkStudent or ResearchStudent files/Records.
         * If the user enter an invalid choice it will ask the user to enter again.
         * Using the Switch-case to break the to the courses into 2 different type and it will show only that course file/records 
         * by using the same Menu by calling Menu() method
         * default will print-out an invalid choice statement and ask the user to enter again.
         */
        StudentInfo();
        System.out.println();
        while(true)
        {     
            System.out.println("Which Student would you like to see?, Enter 1 or 2 [1]: CourseWorkStudent or [2]: ResearchStudent. : ");
            FirstOption = read.nextInt();
        
             switch(FirstOption)
            {
                case 1:
                     // CourseWorkStudent
                    Menu(); 
                    break;
                case 2:
                    // ResearchStudent
                    Menu(); 
                    break;
                 default:
                    System.out.println("Invalid Choices, Please try again");
            }// END OF SWITCH
        }// END OF WHILE 
    } // END OF MAIN
} // END OF STUDENTRESULTCLIENT CLASS
