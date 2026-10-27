package edu.aitu.visitor;

public final class Main {
    private Main() { }

    public static void main(String[] args) {
        DirectoryElement root = new DirectoryElement("project");
        root.add(new FileElement("README.md", 120));
        DirectoryElement src = new DirectoryElement("src");
        src.add(new FileElement("Main.java", 350));
        src.add(new FileElement("Visitor.java", 210));
        root.add(src);
        DirectoryElement docs = new DirectoryElement("docs");
        docs.add(new FileElement("visitor-notes.txt", 80));
        root.add(docs);

        SizeCalculatorVisitor size = new SizeCalculatorVisitor();
        root.accept(size);
        SearchVisitor search = new SearchVisitor("visitor");
        root.accept(search);

        System.out.println("Total size: " + size.getTotalBytes() + " bytes");
        System.out.println("Files matching 'visitor':");
        for (String match : search.getMatches()) System.out.println("- " + match);
    }
}
