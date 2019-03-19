###################################################################################################################
#This project contains basic automated scripts for validating My Store online shopping web-app with the url: http://automationpractice.com/index.php

#This a hydrid automation framework project uses Data driven approach over Selenium with TestNG and Maven. Page Object Module has been used to create and define the object for each of the web pages respectively.

#The project has the below folders and packages:
# src/main/java Folder:	
#	com.automationpracticeMyStore.pageObjects - Contains all the pages defining 				  #										               their elements and 	functions 
#														  respectively
# src/test/java Folder:  
#	com.automationpracticeMyStore.tests       - Contains two tests cases, one 
#														  registered user making a item order
#														  and one for item order transaction 
#														  for over a new registration	

#Exectution:
#To execute the scripts: 
#	Step 1: Build the project as Maven build and pom.xml file has the dependencies defined enabling to identify the prerequisites respectively. ===> Right Click on the Project ===> Maven ===> Update Project
#	Step 2: Testng_test_run.xml file has all the automated test cases put a suite to run and will trigger all the scripts respectively. ===> Right Click on Testng_test_run.xml.xml ===> Run as TestNG Suite

#Reporting:
#Reporting: This project uses testng reporting to elaborate the test outcomes in a html report format. test-output folder has index.html file which would be update upon running TestNG suite(Step 2). All output could be seen on the test output link on the index.html page.