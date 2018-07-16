### Summary
1. On Desktop open git bash and fo: `git clone https://github.com/KristineK/cucumber_project.git`
2. In IDEA open project `cucumber_project` from "Desktop/cucumber_project"
3. In IDEA check in project structure, that:
   * Project settings:
   ![Alt text](project_settings.png?raw=true "Project Settings")
   * Modules settings:
   ![Alt text](module_settings.png?raw=true "Module Settings")
4. After making changes do:
   * `git add  .`
   * `git commit -m "message"`
   *  `git push origin <name_surname>` 
   
   sNote: replace <name_surname> with your name and surnameit 

### Task
Create a new Feature file (e.g. in the folder "features" click "New" -> "File" -> "Task.feature"), and inside write a few scenarios for the page https://kristinek.github.io/test-sample/tasks/task4 
1) enter some values into the field, press "Send", check that correct data appears
2) enter some values into the field (do not fill the "name" field), press "Send", press "Yes", check that the correct message appears - "Thank you for your feedback!"
3) enter some values into the field (fill the "name" field), press "Send", press "Yes", check that the correct message appears - "Thank you, " + name_you_entered + ", for your feedback!"
4) enter some values into the field, press "Send", press "No", check that the values which where filled previously are still filled

### Feedback
