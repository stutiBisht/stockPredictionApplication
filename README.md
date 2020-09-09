# StockPredictionApplication

StockPredictionApplication is being created to manage stocks data related to different indexes, this data can be useful for predicting stocks values for upcoming weeks, currently application is only managing data for Dow Jones index. 
Below are the technologies I have embedded in StockPredictionApplication.<br/>
1) Microservices architecture <br/>
2) Application is built upon springboot thus using its multiple dependencies like security, jpa, validation, devtools (all the     dependencies are described in build.gradle file)<br/>
3) Rest API<br/>
4) Jasper for JSP integration<br/>
4) Spring security for basic authentication<br/>
5) postgress DB for database<br/>
6) gradle for building project<br/>
7) Java 8<br/>
8) git<br/>
9) Junit4 for junit testcase<br/>

**Prerequisites**: <br/>
**1) PostgressSQL db:** Please install postgresssql13 or download postgress docker image before starting application, once postgress is up and running go to pgadmin4 app and create DB as **stockManagementDB** . Once DB is created, please create table by createTable.sql (present in resource folder)<br/>
 **Please Note:** : Either use postgress password as "password" or update **spring.datasource.password** property value in application.properties for your password.<br/>
**2) postman/soapui to test rest apis:** Please install any of these two tool and import project stockManagementProject in your tool(project present in resource folder), you should be able to see get and add request inside your postman project. <br/>

**Steps to build and deploy application:** Import application in IDE as existing gradle project, let gradle fetch all the dependencies from artifactory. Once gradle build is successful, right click on Project > Properties > Java Build Path > Add Lib > Add Junit4 lib and apply changes, now run application as java application and select type as StockPredictionApplication. Application should be up and running and log should be rolling in console/app.log in temp folder.

**Steps to test application:** currently application is supporting below three operations.

1) **upload bulk data from .txt file:** By this functionality multiple records can be inserted to db by multiple users concurrently. To test this functionality, Go to your browser and hit **http://localhost:8080/api-investment/stock-prediction/login** , you will be prompted to spring defaultlogin screen. Provide user and password as **"user"** and **"password"**. Once login, you can use djIndex.txt(present in resource folder) for upload file functionality. after getting successful you cross-verify in db if records inserted or not.<br/>
 **Please Note:**combination of stock and closing date should always be unique, so you cant upload same file twice. if you want to upload same file again, please restart the server(by restarting server previous data will be deleted from table) and try above mentioned steps again.<br/>

 2) **getDataForStock:** By this functionality, we can fetch multiple records for given stock. To test this functionality, go to postman/soapUi and trigger request for getStockData.<br/>
 
3) **addDataForStock:**  By this functionality, we can add single row of records for given stock into DB. To test this functionality, go to postman/soapUi and trigger request for addStockData. Please use unique combination of stock and close_date while inserting data.<br/>
