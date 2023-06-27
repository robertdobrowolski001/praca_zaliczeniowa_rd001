@edit

Feature: User account edit

#  Scenario: User adds first address to account
#
#    Given I'm on the store authentication page
#    When I login using "boblop@bobo.com" and "mypass"
#    Then I go to my addresses page
##   Then I can see there is no addresses
#    When I add new address
#    And I enter new address "Alias", "Street", "City", "54-000", "123456789"
#    Then I can see new address
#    And I verify created address "Alias", "Street", "City", "54-000", "123456789"
##    And I delete the address
##    And I can see the address was deleted



  Scenario Outline: User adds first address to account

    Given I'm on the store authentication page
    When I login using "boblop@bobo.com" and "mypass"
    Then I go to my addresses page
    When I add new address
    And I enter new address <alias>, <address>, <city>, <zipcode>, <phone>
    Then I can see new address
    And I verify created address <alias>, <address>, <city>, <zipcode>, <phone>
#    And I delete the address
    ##    And I can see the address was deleted
#    And I close the browser

    Examples:
      | alias  | address | city     | zipcode | phone     |
      | Nobody | Blvd    | MegaCity | 66-066  | 123456789 |

