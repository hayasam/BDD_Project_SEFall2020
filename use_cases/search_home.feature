Feature: Search about suitable home

  Background: The System has a repository of homes with their specifications (type-material-placement-pets-amenties-price-area-bedrooms-bathrooms-leaselength)
    Given these homes are contained in the system
      | HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR | 510_150_3_2_6  |
      | APARTMENT_BRICK_CITY_NO_ELEVATOR                       | 230_120_4_1_12 |
      | APARTMENT_BRICK_VILLAGE_NO_SWIMMINGPOOL                   | 100_120_4_2_6 |
      | HOUSE_STONE_VILLAGE_NO_SWIMMINGPOOL                   | 150_120_3_2_12 |

  @byType
  Scenario Outline: Search home by type
    When I search about home by "APARTMENT"
    Then A list of homes that matches the  type specification should be returned and printed on the console
   
      
  @byMaterial
  Scenario: Search home by material
    When I search about home by "BRICK"
    Then A list of homes that matches the  material specification should be returned and printed on the console
    And email with the result should be send to user "hayasam@najah.edu"
   
 
    
     
  @byPlacement
  Scenario Outline: Search home by placement
    When I search about home by "CITY"
    Then A list of homes that matches the  placement specification should be returned and printed on the console
      And email with the result should be send to user "hayasam@najah.edu"
   

  @byPrice
  Scenario: Search about home with less than a specific price
    When I search about home with price less than 250
    Then A list of homes that matches the price specification should be returned and printed on the console
     And email with the result should be send to user "haya.sammaneh@gmail.com" and "h2@najah.edu"
   
    @byArea
  Scenario: Search about home with less than a specific area
    When I search about home with area less than 180
    Then A list of homes that matches the area specification should be returned and printed on the console
     And email with the result should be send to user "hayasam@najah.edu"
   
