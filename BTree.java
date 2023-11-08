package prog8;
/*
 * Author: Reed Elliott
 * Purpose: container for binary tree of BTreeNode
 * */

public class BTree {

	private BTreeNode root;

	public BTree() {
		this.root = null;
	}

	public void insert(String key) {
		if (this.root == null)
			this.root = new BTreeNode(key);
		else {
			this.root.insert(key);
		}
	}

	public long getHeight() {
		return this.root != null ? this.root.getHeight() : 0;
	}

	public long getNodeCount() {
		return this.root != null ? this.root.getNodeCount() : 0;
	}

}
