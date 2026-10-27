package edu.aitu.visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public final class SearchVisitor implements FileSystemVisitor {
    private final String query;
    private final List<String> matches = new ArrayList<>();
    private final List<String> path = new ArrayList<>();

    public SearchVisitor(String query) {
        this.query = Objects.requireNonNull(query, "query").toLowerCase(Locale.ROOT);
        if (query.isBlank()) throw new IllegalArgumentException("Search query cannot be blank");
    }

    public List<String> getMatches() { return List.copyOf(matches); }

    @Override
    public void visitFile(FileElement file) {
        if (file.getName().toLowerCase(Locale.ROOT).contains(query)) {
            matches.add(String.join("/", path) + "/" + file.getName());
        }
    }

    @Override
    public void visitDirectory(DirectoryElement directory) {
        path.add(directory.getName());
        try {
            for (FileSystemElement child : directory.getChildren()) child.accept(this);
        } finally {
            path.remove(path.size() - 1);
        }
    }
}
