package edu.aitu.visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class DirectoryElement implements FileSystemElement {
    private final String name;
    private final List<FileSystemElement> children = new ArrayList<>();

    public DirectoryElement(String name) {
        this.name = Objects.requireNonNull(name, "name");
        if (name.isBlank()) throw new IllegalArgumentException("Directory name cannot be blank");
    }

    public String getName() { return name; }
    public List<FileSystemElement> getChildren() { return List.copyOf(children); }

    public void add(FileSystemElement child) {
        Objects.requireNonNull(child, "child");
        if (child == this) throw new IllegalArgumentException("Directory cannot contain itself");
        if (child.containsDirectory(this)) {
            throw new IllegalArgumentException("Directory cycle is not allowed");
        }
        children.add(child);
    }

    @Override
    public boolean containsDirectory(DirectoryElement target) {
        if (this == target) return true;
        for (FileSystemElement child : children) {
            if (child.containsDirectory(target)) return true;
        }
        return false;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        Objects.requireNonNull(visitor, "visitor").visitDirectory(this);
    }
}
