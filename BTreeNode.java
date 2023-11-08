package prog8;
/*
 * Author: Reed Elliott
 * Purpose: BTreeNode for binary tree contained in BTree
 * */

import java.lang.Math;

public class BTreeNode {

	private final String value;
	private BTreeNode left, right;

	public BTreeNode(String value) {
		this.value = value;
	}

	public void insert(String key) {
		if (this.value.equals(key))
			return;

		if (this.value.compareTo(key) > 0) {
			if (this.left == null)
				this.left = new BTreeNode(key);
			else
				this.left.insert(key);
		} else {
			if (this.right == null)
				this.right = new BTreeNode(key);
			else
				this.right.insert(key);
		}
	}

	// This is post-order: left, right, self
	// adding 1 in the return statement is self
	public long getHeight() {
		long leftNodes = this.left != null ? this.left.getHeight() : 0;
		long rightNodes = this.right != null ? this.right.getHeight() : 0;
		return 1 + Math.max(leftNodes, rightNodes);
	}

	// This is post-order: left, right, self
	// adding 1 in the return statement is self
	public long getNodeCount() {
		long leftNodes = this.left != null ? this.left.getNodeCount() : 0;
		long rightNodes = this.right != null ? this.right.getNodeCount() : 0;
		return 1 + leftNodes + rightNodes;
	}

}
