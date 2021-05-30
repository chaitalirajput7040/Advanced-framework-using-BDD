@Regression
Feature: Testing Online fruit and  veggies App

Background:
Given User launches the app

@Valid_Scenario 
Scenario: Valid Credentials
When User gives right "Online_User" as Username and "Online_User" as password
Then User should see success message

@Valid_Scenario_encrypt 
Scenario: Valid Credentials
When User in encryption gives "Online_User" as Username and "T25saW5lX1VzZXI=" as password
Then User should see success message


@Valid_Scenario_excel 
Scenario: Valid Credentials
When User gives credentials through excel
Then User should see success message


@Valid_Scenario_DB
Scenario: Valid Credentials
When User gives credentials using database
Then User should see success message

@Invalid_Scenario   
Scenario: Invalid Credentials
When User gives invalid credentials "myuser1" as username and "mypass1" as password
Then User should see Error message

@Valid_Scenario1 
Scenario: Valid Credentials
Given User launches the app
When User gives right  Username and password
|Online_User|Online_User|
Then User should see success message


@Invalid_Scenario1   
Scenario Outline: Invalid Credentials
Given User launches the browser
When User gives invalid credentials <uname> as username and <pass> as password
Then User should see Error message
Examples:
|uname|pass|
|"user1"|"mypass1"|
|"user2"|"mypass2"|
|"user3"|"mypass3"|




  