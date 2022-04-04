Feature: SandBox

Scenario: Pruebo diferentes acciones en el dropdown
    Given Navego a la pagina del dropdown
    And Selecciono una opcion del dropdown

@Test
Scenario Outline: Validar si un texto esta presenta en la lista
    Given Navego a la webpage
    When Busco <state> en la lista
    Then Encuentro <city> en la lista

    Examples:
        | state        | city                     |
        | Washington   | Seattle, Washington      |
        | Los Angeles  | Los Angeles, California  |