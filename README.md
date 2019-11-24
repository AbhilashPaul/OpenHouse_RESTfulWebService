OpenHouse RESTful WebService

The WebService is able to consume logs from the front end application and store them into a database. 
Currently, the logs are stored in an in memory H2 database.

At the moment, WebService provides endpoints to retrieve all the logs and logs by user and session.

Thoughts on cloud scalability
  - Scale horizontally: For scalability, deploy the application on the cloud using services such as Amazon EC2 which provides means to scale horizontally.
  - Backend databases can be hosted by Amazon RDS, DynamoDB or Heroku Postgres.
  - Strive to keep the service oriented architecture of the app. 
