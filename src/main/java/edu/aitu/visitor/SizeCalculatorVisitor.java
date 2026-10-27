package edu.aitu.visitor;

public final class SizeCalculatorVisitor implements FileSystemVisitor {
    private long totalBytes;

    public long getTotalBytes() { return totalBytes; }

    @Override
    public void visitFile(FileElement file) {
        totalBytes = Math.addExact(totalBytes, file.getSizeBytes());
    }

    @Override
    public void visitDirectory(DirectoryElement directory) {
        for (FileSystemElement child : directory.getChildren()) child.accept(this);
    }
}
