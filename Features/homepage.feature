@Tag
Feature: Open Aspirations home page and products page 

@Tag1
Scenario: View products through Spend and Save link

Given Open the chrome browser and visit the homepage

When User click to accept cookie
And User navigates to the Spend and Save link and click
Then User should be able to view Products and prices

@Tag2
Scenario: view Get Aspiration card product

Given After verifying Get Aspiration is displayed
When User click on Get Aspiration
Then A modal containing an input field for email address to sign up appears


@Tag3
Scenario: verify Get Aspiration plus card product

Given User goes back to Homepage
When User clicks on spend and save link
And User clicks on Get Aspiration plus
Then User verify that monthly and yearly modal appears
And User verify that yearly radio option is "$71.88" paid once yearly
And User verify that monthly radio option is "$7.99" paid monthly

@Tag4
Scenario: close web page

Then quit web page