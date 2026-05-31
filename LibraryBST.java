class Node {
    int bookId;
    Node left, right;

    Node(int bookId) {
        this.bookId = bookId;
        left = right = null;
    }
}

public class LibraryBST {

    Node root;

    Node insert(Node root, int bookId) {
        if (root == null) {
            return new Node(bookId);
        }

        if (bookId < root.bookId)
            root.left = insert(root.left, bookId);
        else
            root.right = insert(root.right, bookId);

        return root;
    }

    boolean search(Node root, int bookId) {
        if (root == null)
            return false;

        if (root.bookId == bookId)
            return true;

        if (bookId < root.bookId)
            return search(root.left, bookId);

        return search(root.right, bookId);
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.bookId + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        LibraryBST tree = new LibraryBST();

        int books[] = {101, 105, 110, 115};

        for (int book : books)
            tree.root = tree.insert(tree.root, book);

        System.out.println("Library Books:");
        tree.inorder(tree.root);

        int searchBook = 110;
        if (tree.search(tree.root, searchBook))
            System.out.println("\nBook Found: " + searchBook);
        else
            System.out.println("\nBook Not Found");
    }
}