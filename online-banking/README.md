# Module two final project

There are four options for this final project:

1. Implement the Solar Systems Geek application described later in this document.
2. Create and implement your own application.
3. Implement an application for a [Trello board project](https://trello.com/b/SHSRQCza/te-module2-final-projects).
4. If you completed a custom application for the mid-module project, you can extend and build upon it for the final project.

The Solar Systems Geek application is a guided project with clear requirements describing the work you must do. However, since this application's design and instructions are part of the program curriculum, you can't host it publicly or use it directly in your software portfolio.

## Design Requirements

All applications must include project design documents, charts, and/or diagrams.
 * Place the database ERD in the `database` folder.
 * Submit all other required design documents in the `design` folder at the root of this project.
 * Recommended design documents are optional.

### Required

* [**Custom project only**] Documentation of functional requirements to act as the application's Minimum Viable Product ([MVP](https://en.wikipedia.org/wiki/Minimum_viable_product)).
  * A functional requirement describes what the application can do or provide from a user's perspective.
  * Capture functional requirements as a *[user story](https://en.wikipedia.org/wiki/User_story)*. Examples:
    * "As an unauthenticated user, I can review a list of products for sale."
    * "As an authenticated user, I can clear my cart, removing all items from the cart."
  * At least one functional requirement must require authentication
* Database ERD diagram which includes:
  * At least one table in addition to the provided users table
  * All columns, relationships, and constraints for each table
* API endpoint design document which includes a list of all endpoints:
  * List HTTP method and URL
  * Indicate any path variables or query parameters
  * Indicate if the endpoint requires authentication and/or authorization roles
  * Success and error status codes
  * Any JSON request and/or response body schemas

Below is an example of API endpoint design table:

| Endpoint              | Method | Query Parameters                        | Description                   | Success | Error    | Authentication   |
|:----------------------|:------:|:----------------------------------------|:------------------------------|:-------:|:---------|:-----------------|
| /api/reservation      |  GET   | dateto, optional<br/>datefrom, optional | Get all reservations          |   200   | 400      | None             |
| /api/reservation      |  POST  | None                                    | Create a new reservation      |   201   | 400, 422 | Required         |
| /api/reservation/{id} |  GET   | None                                    | Get a specific reservation    |   200   | 404      | Creator or ADMIN |
| /api/reservation/{id} |  PUT   | None                                    | Update a specific reservation |   200   | 404, 409 | Creator or ADMIN |
| /api/reservation/{id} | DELETE | None                                    | Delete a specific reservation |   204   | 404      | ADMIN            |

### Recommended

* Class summaries
  * Instance variables
  * public methods
  * Inheritance or interface relationships
  * Examples:
    * DAO interfaces with method descriptions
    * Model classes
      * DTO @valid checks
    * Service classes
* Flow charts or [Sequence diagrams](https://en.wikipedia.org/wiki/Sequence_diagram)
  * Summarize end-to-end HTTP request to HTTP response for API endpoints
* Database Integration Test Plan
  * Happy Path test cases
  * Corner cases
  * Success criteria
  * Mock users and/or mock test data

## Creating or extending your own application

If you decide to create your own application or extend upon your mid-module project, **you must confirm your application proposal with your instructor.**

### Requirements

At a minimum, your application must meet the following minimum requirements:

* Have a clear purpose, function, or utility.
* Document at least five functional requirements with at least one requiring an authenticated user.
  * The provided login and registration flow **can not** be used as one of the five functional requirements.
  * Requirements utilizing the methods from the provided `userDao` class **can not** be used as one of the five minimum functional requirements.
* Use Spring Boot and Postgres to create a backend web service.
* Implement a REST API with appropriate, authenticated endpoints.
  * At least one endpoint must require meaningful authentication.
* Use the DAO pattern to access the database.
* Provide a SQL script to create tables and any mock data.

The use of an external API is highly recommended, but not required.

## Creating an application from a Trello Board Project

[Trello Board projects](https://trello.com/b/SHSRQCza/te-module2-final-projects) contain *[user story](https://en.wikipedia.org/wiki/User_story)* cards, which act as the project's functional requirements.
Each card in a Trello Board is color coded with a green, red, or blue label.
 * Green label - Information only, no work needs to be done.
 * Red label - A user story that is a part of the minimum requirements to complete the project. These user stories must all be implemented to achieve a Minimum Viable Product ([MVP](https://en.wikipedia.org/wiki/Minimum_viable_product)).
 * Blue or Orange label - A user story that is optional and should only be completed *after* completing all the MVP (red) user stories.

Below is an example from the City Tours project:

![Trello_board](./trello.png) ![Trello_labels](./trello-labels.png)

### Trello project requirements

At a minimum, your application must meet the following minimum requirements:

* Use Spring Boot and Postgres to create a backend web service.
* Implement a REST API with appropriate, authenticated endpoints.
* Use the DAO pattern to access the database.
* Provide a SQL script to create tables and any mock data.
* Complete all, or at least five, of the MVP (red) User Stories.

The use of an external API is highly recommended, but not required.

## Database setup

To run the application, you must first create the `m2_final_project` database. Then run the `database/m2_final_project.sql` script to create the user table with some test users.

> Note: The script creates two users for testing, `user` and `admin`, which both have the password: `password`.

![Database schema](./database/m2_final_project_ERD.drawio.png)

## Running the starter code

Use the code in this project as the starter code for your project.
After setting up the database, run the application from the Application class. There should be no errors.

Import the `postman/M2-Final_Project.postman_collection.json` into Postman as a collection.
Open the Login and Register requests and test they work.

## Solar Systems Geek REST API

In this project, you'll build a REST API to support an e-commerce shopping cart.

The [Requirements](#requirements) section later in this document describes the endpoints needed.

## Requirements

The requirements are for a database and RESTful web API only. There are no requirements for a user interface. Perform testing of the required endpoints by using Postman.

### Database design

The database for Solar System Geeks e-commerce store needs to keep track of products and each user's shopping cart.

#### Products

Each Product has the following attributes:
* product_sku
* name
* description
* price
* image_name

You must add the following products:

| product_sku |           name           |         description        | price  |     image_name      |
|:-----------:|:------------------------:|:--------------------------:|:------:|:-------------------:|
| MUG-023     |  Solar Geeks coffee mug  |  Start your day off right! | $14.99 | Product-MUG-023.jpg |
| YET-001     |    Solar Geeks Yeti      |   Keep cool all day long.  | $21.99 | Product-YET-001.jpg |
| ART-256     |     Galactic poster      | Beautiful view of a galaxy | $9.59  | Product-ART-256.jpg |
| TOY-978     |        Toy rocket        |   To infinite imagination  | $39.99 | Product-TOY-978.jpg |
| EAT-235     |   Astronaut ice cream    |      As cold as space      | $5.79  | Product-EAT-215.jpg |
| HAT-928     | Solar Geeks baseball cap | Look stylish with our logo | $16.89 | Product-HAT-908.jpg |
| LIT-612     |  Intro to Astrophysics   |  Learn about astrophysics  | $7.99  | Product-LIT-612.jpg |

#### Shopping cart

Each authenticated user has a shopping cart that can hold many products.
Each product can appear in more than one shopping cart.
An authenticated user can only have a single shopping cart.

The shopping cart has the following attributes:
* The user associated with the shopping cart
* The product to purchase
* The product quantity to purchase

If an authenticated user has a product in their cart and then adds the same item to their cart again,
the shopping cart must contain only a single entry for that product with a quantity of 2.

The shopping cart must have a *primary key* for each entry into the shopping cart.
This key differentiates items added to the same user's shopping cart at different times. This supports clearing the cart and adding some of the same items again.

### REST API

There are three groupings of requirements:

- **Provided**: documents the provided features in the starter code
- **Required**: features required to complete the project
- **Bonus**: optional features to extend the project and further develop your skills

### Provided

Use cases:
1. As an unauthenticated user, I need to be able to register myself with a username, address information, and password.
1. As an unauthenticated user, I need to be able to log in using my registered username and password.

API endpoints:
1. POST `/register` (Provided Use Case 1)
1. POST `/login` (Provided Use Case 2)

### Required

Use cases:
1. As an unauthenticated user, I can review a list of products for sale.
1. As an unauthenticated user, I can search for a list of products by name or SKU.
1. As an unauthenticated user, I can view additional information about a specific product (product detail).
1. As an authenticated user, I can view my shopping cart and see the following details:
    * The list of products, quantities, and prices in my cart
    * The subtotal of all products in my cart
    * The tax amount (in U.S. dollars) charged for my state
        - Obtain the tax rate from an external API using the URL: https://teapi.netlify.app/api/statetax?state=[state-code].
        - The state code is part of the user address information.
        - The tax rate returned from the API is a percentage. Convert this to a decimal value to use in calculating the tax amount.
    * The cart total, which is the subtotal plus the amount of tax
1. As an authenticated user, I can add a product to my shopping cart.
    * If the product is already in my cart, increase the quantity appropriately.
    * The quantity added must be positive.
1. As an authenticated user, I can remove an item from my shopping cart. This action removes this product from the cart entirely, regardless of the quantity in the cart.
1. As an authenticated user, I can clear my cart, removing all items from the cart.

Create API endpoints to perform the following:
1. Get the list of products (Required Use Case 1)
1. Search for products by product name or SKU (Required Use Case 2)
1. Get a single product (Required Use Case 3)
1. Get the user's cart (Required Use Case 4)
1. Add an item to the user's cart (Required Use Case 5)
1. Remove a single item from the user's cart (Required Use Case 6)
1. Clear the user's cart (Required Use Case 7)

### Bonus (Optional)

An authenticated user can have zero or many wishlists. Each wishlist has the following properties:
* The user associated with the shopping cart
* The name of the wishlist

A wishlist can contain many products and a product can appear on many wishlists.

A wishlist item (product) is unique and can only appear once within a wishlist.

Use cases:
1. As an authenticated user, I can see a list of all my wishlists.
1. As an authenticated user, I can see a single wishlist, including a list of the items on the wishlist.
1. As an authenticated user, I can create and name a new wishlist.
1. As an authenticated user, I can delete an existing wishlist that I own.
1. As an authenticated user, I can add a product to a wishlist that I own. If the item is already on the wishlist, it's not added again, and no error occurs.
1. As an authenticated user, I can remove a product from a wishlist that I own. If the item isn't on the wishlist, there's nothing to delete but no error occurs.

API endpoints:
1. Get user wishlists (Bonus Use Case 1)
1. Get wishlist (Bonus Use Case 2)
1. Create a wishlist (Bonus Use Case 3)
1. Remove wishlist (Bonus Use Case 4)
1. Add the product to the wishlist (Bonus Use Case 5)
1. Remove the product from the wishlist (Bonus Use Case 6)
