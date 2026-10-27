package edu.aitu.visitor;

public interface FileSystemVisitor {
    void visitFile(FileElement file);
    void visitDirectory(DirectoryElement directory);
}
