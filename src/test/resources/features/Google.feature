Feature: Probar la busqueda en google

Scenario: Busco algo en Google
    Given I am on the Google search page
    When I enter a search criteria
    And clic on the search button
    Then the results match the criteria