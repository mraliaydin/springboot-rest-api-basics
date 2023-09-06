# Basic Project For Spring Boot Rest APIs

This project includes basic rest controllers for CRUD operations.

## To Run the Project

Use an IDE to run a Java Spring Boot then run SpringbootRestApiApplication class.


## Usages

- Controllers mostly return Student objects. Objects are static and just for observing implementations.

Example:

```java

// HTTP Get Request
// ResponseEntity is used to manipulate the HTTP Responses
@GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1,"Ali","Veli");

       
        //.header creteas an header with a name and a value.
        return ResponseEntity.ok().header("custom-header", "ali")
                .body(student);
    }

```

## License

[MIT](https://choosealicense.com/licenses/mit/)
