# java--sql
 The program:  
 ○ Reads and writes data about projects and people associated with projects from your database instead of text files.  
 ○ Capture information about new projects and add these to the database.  
 ○ Update information about existing projects.   
 ○ Finalise existing projects. When a project is finalised the following should happen: 
 
 ■ An invoice should be generated for the client. This invoice should contain the customer’s contact details and the to amount that the customer must still pay. This amount is     calculatedbysubtractingthetotalamountpaidtodatefrom the total fee for the project. If the customer hasalreadypaid the full fee, an invoice should not be generated.  
 ■ The project should be marked as “finalised” and the completion date should be added. 
 
○ Find all projects that still need to be completed from the database.   
○ Find all projects that are past the due date from the database.  
○ Find and select a project by entering either the project number or project name.  

Program should also do the following:  
○ Include exception handling. Use try-catch blocks wherever appropriate.  
○ Remove all errors from your code. Take extra care to detect and remove all logical and runtime errors.  
○ Adequately refactor code
