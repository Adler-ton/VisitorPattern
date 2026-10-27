package edu.aitu.visitor;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
    default boolean containsDirectory(DirectoryElement target) { return false; }
}
