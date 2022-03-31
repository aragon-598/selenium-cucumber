Feature: Probar la busqueda en google

Scenario: Busco algo en Google
    Given navego a Google
    When busco algo
    Then Obtengo resultados