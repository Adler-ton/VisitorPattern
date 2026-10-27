# File System Visitor Pattern

Java 17 implementation of the Visitor behavioral design pattern using a directory tree. `SizeCalculatorVisitor` totals file sizes and `SearchVisitor` finds filenames containing a case-insensitive query.

## Run

```bash
javac -d out src/main/java/edu/aitu/visitor/*.java
java -cp out edu.aitu.visitor.Main
```

## Structure

- `src/main/java/edu/aitu/visitor/` — elements, visitors, and demo
- `src/test/java/edu/aitu/visitor/` — standalone assertions
- `uml/` — UML source and diagram
