package edu.aitu.visitor;

public final class VisitorTest {
    public static void main(String[] args) {
        DirectoryElement root = new DirectoryElement("root");
        DirectoryElement nested = new DirectoryElement("nested");
        root.add(new FileElement("Visitor.java", 15));
        nested.add(new FileElement("notes.txt", 5));
        root.add(nested);
        SizeCalculatorVisitor size = new SizeCalculatorVisitor();
        root.accept(size);
        if (size.getTotalBytes() != 20) throw new AssertionError("Incorrect total size");
        SearchVisitor search = new SearchVisitor("VISITOR");
        root.accept(search);
        if (!search.getMatches().equals(java.util.List.of("root/Visitor.java"))) throw new AssertionError("Incorrect matches");
        try { root.add(root); throw new AssertionError("Cycle accepted"); }
        catch (IllegalArgumentException expected) { /* expected */ }
        try { nested.add(root); throw new AssertionError("Indirect cycle accepted"); }
        catch (IllegalArgumentException expected) { /* expected */ }
        System.out.println("All tests passed");
    }
}
