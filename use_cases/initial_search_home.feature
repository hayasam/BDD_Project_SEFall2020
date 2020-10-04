
Feature: Search about suitable home
  
Background: The System has a repository of homes with their specifications (type-material-placement-pets-amenties-price-area-bedrooms-bathrooms-leaselength)
Given  these homes are contained in the system
                |HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR|510_150_3_2_6|
                |APARTMENT_BRICK_CITY_NO_ELEVATOR|230_120_4_2_12|
               
               
  Scenario Outline: Search home by type
  When I search about home by <type>
  Then A list of homes that matches the  type specification should be returned and printed on the console
  
  Examples:
 | type|
 |"HOUSE"|
 |"APARTMENT"|

  Scenario: Search about home with less than a specific price
    When I search about home with price less than 400
    Then A list of homes that matches the price specification should be returned and printed on the console
    And email with the result should be send to user "hayasam@najah.edu"
   
