Feature: SandBox

# Scenario: Pruebo diferentes acciones en el dropdown
#     Given Navego a la pagina del dropdown
#     And Selecciono una opcion del dropdown

#@Test
#Scenario: Obtengo un valor de la celda de una tabla estatica
#    Given Navego a la tabla
#    And Retorno el valor deseado

#Scenario: Obtengo un valor de la celda de una tabla estatica, existe
#    Given Navego a la tabla
#    Then Valido la ceda

Scenario: Validar si un texto esta presenta en la lista
    Given Navego a la webpage
    When Busco la lista
    Then Encuentro el texto en la linea