# ExpenseTracker-API-SpringBoot

## Introduction
The Expense Tracker API is a powerful tool that allows users to effortlessly track their expenses. With this API, users can create, read, update, and delete expenses, as well as generate comprehensive reports on a monthly or weekly basis. To ensure secure access, users are required to sign in or register before utilizing the API's functionalities.

Features:
* Expense Management: Users can create and manage their expenses with detailed information, including the product title, description, price, date, time, and associated user ID.
* Fetching Expenses: The API provides an endpoint to fetch all the expenses for a particular date and time. Users can specify the desired date, and optionally, the time, to retrieve relevant expense records.
* Total Expenditure Calculation: Users can request the API to generate the total expenditure for a given month. By providing the desired month, the API calculates and returns the cumulative expenses incurred by the user during that period.
* Database and Deployment: The API utilizes a MySQL database to store expense records, ensuring data persistence. The deployment link's IP address is static, offering consistent access to the API and its functionalities.
* Validation: The Expense Tracker API implements annotation-based validation to ensure data integrity and reliability. This validation process helps prevent erroneous or incomplete data from being stored or processed.

### Frameworks Language and Database used:
* Spring boot
* Java
* MySQL
* AWS for deployment
* Maven

### Data Flow
* Controller : 
  * In this Application 2 controllers are used :
    * ProductController
    * UserController
* Service
  * In this Application 2 services are used :
    * ProductService
    * UserService
* Dao
  * In this Application 2 dao are used :
    * ProductDao
    * UserDao
  
### Project Summery
The purpose behind creating an Expense Tracker API is to help individuals manage their finances effectively by keeping track of their expenses. This API aims to provide a simple and convenient way for users to record their expenses and analyze their spending habits. Also this API allows users to easily input their expenses, which are then stored in a database. Users can retrieve their expense records on demand, either for the current month or up until the current date. This enables users to track their spending and identify areas where they may be overspending or where they can cut back to achieve their financial goals.


## Below link shows the API test using swagger
http://16.171.61.112:8080/swagger-ui/index.html#/



## Links
  ### There are proper mapping given in the controller through which one can access the APIs by cloning it into their device
    
  
