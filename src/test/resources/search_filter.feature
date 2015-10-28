Feature: As a user
  I want to filter the search results
  So not long to find the right product

  Scenario: Check filtering by price
    Given Open site pn.com.ua
    When Select category "Компьютеры"
    And Select subcategory "Ноутбуки, планшеты"
    And Set the minimum and maximum price
    Then The results satisfy the search parameters

  Scenario: Check the filter by name of manufacturer
    Given Open site pn.com.ua
    When Select category "Компьютеры"
    And Select subcategory "Ноутбуки, планшеты"
    And Select any manufacturer
    Then Check that the number of goods equal to the amount specified beside the name
    And Check that names of products start with manufacturer name

  Scenario: Check search by name of product
    Given Open site pn.com.ua
    When Select category "Компьютеры"
    And Select subcategory "Ноутбуки, планшеты"
    And Sort goods by price
    And Take the name of cheapest product
    And Enter name in search field
    Then Check that result is equal "1"
    And Check that the name of the product is equal to the name specified
