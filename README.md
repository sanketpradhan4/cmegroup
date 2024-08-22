Assumptions :
Spring Boot Application: The program will be implemented using Spring Boot, providing the RESTful web service framework.
Java Version: Java 8 will be used for the implementation.
Cache Mechanism: A simple in-memory cache will be used, implemented using a ConcurrentHashMap. This will provide thread-safe operations.
Permanent Storage: The storage will initially be a file system, where processed palindrome results will be stored in a text file. This will allow easy substitution with a database or other persistent storage solution in the future.
Validation: The initial implementation will reject input that contains spaces or numbers. Further validations can be added easily by extending the validation component.
Performance: The API will respond immediately after the palindrome check and caching, without waiting for the persistence process to complete (asynchronous persistence).
Testing: JUnit and Spring's testing framework will be used to provide unit tests and integration tests.

Download and follow below steps :
1. mvn clean
2. mvn install
Internal tests will be fired.
